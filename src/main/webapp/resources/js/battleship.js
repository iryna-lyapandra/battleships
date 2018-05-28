var model = {
    boardSize: 7,
    numShips: 3,
    shipLength: 3,
    shipsSunk: 0,
    guesses: 0,

    ships: [
        {locations: [0, 0, 0], hits: ["", "", ""]},
        {locations: [0, 0, 0], hits: ["", "", ""]},
        {locations: [0, 0, 0], hits: ["", "", ""]}
    ],

    fire: function (guess) {
        //Creating a new XMLHttpRequest object

        var xmlhttp;
        var url = "check?guess=" + guess;

        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari
        }
        else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
        }
        //Create a asynchronous GET request
        xmlhttp.open("GET", url, true);

        //When readyState is 4 then get the server output
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    var result = xmlhttp.responseText;
                    var parsedGuess = parseGuess(guess);

                    model.guesses++;
                    if (result == "hit") {
                        view.displayHit(parsedGuess);
                        view.displayMessage("HIT!");
                    }
                    else if (result == "miss") {
                        view.displayMiss(parsedGuess);
                        view.displayMessage("You missed.");
                    }
                    else {
                        model.shipsSunk++;
                        view.displayHit(parsedGuess);
                        view.displayMessage("Kill!");

                        if (model.shipsSunk == model.numShips){
                            view.displayMessage("You sank all my battleships, == in " + model.guesses + " guesses");
                        }
                    }
                }

                else {
                    alert('Something is wrong !!');
                }
            }
        }
        xmlhttp.send(null);
    },

    generateShipLocations: function () {
        //Creating a new XMLHttpRequest object
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
        }
        //Create a asynchronous GET request
        xmlhttp.open("GET", "init", true);

        //When readyState is 4 then get the server output
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    // view.displayMessage (xmlhttp.responseText);
                    //alert(xmlhttp.responseText);
                }
                else {
                    alert('Something is wrong !!');
                }
            }
        };
        xmlhttp.send(null);
    },
};

var view = {
    displayMessage: function (msg) {
        var messageArea = document.getElementById("messageArea");
        messageArea.innerHTML = msg;
    },

    displayHit: function (location) {
        var cell = document.getElementById(location);
        cell.setAttribute("class", "hit");
    },

    displayMiss: function (location) {
        var cell = document.getElementById(location);
        cell.setAttribute("class", "miss");
    }

};

var controller = {
    guesses: 0,

    processGuess: function (guess) {
        this.guesses++;
        var hit = model.fire(guess);
    }
};


// helper function to parse a guess from the user
function parseGuess(guess) {
    var alphabet = ["A", "B", "C", "D", "E", "F", "G"];

    if (guess === null || guess.length !== 2) {
        alert("Oops, please enter a letter and a number on the board.");
    } else {
        var firstChar = guess.charAt(0);
        var row = alphabet.indexOf(firstChar);
        var column = guess.charAt(1);

        if (isNaN(row) || isNaN(column)) {
            alert("Oops, that isn't on the board.");
        } else if (row < 0 || row >= model.boardSize ||
            column < 0 || column >= model.boardSize) {
            alert("Oops, that's off the board!");
        } else {
            return row + column;
        }
    }
    return null;
}


// event handlers

function handleFireButton() {
    var guessInput = document.getElementById("guessInput");
    var guess = guessInput.value.toUpperCase();

    controller.processGuess(guess);

    guessInput.value = "";
}

function handleKeyPress(e) {
    var fireButton = document.getElementById("fireButton");

    // in IE9 and earlier, the event object doesn't get passed
    // to the event handler correctly, so we use window.event instead.
    e = e || window.event;

    if (e.keyCode === 13) {
        fireButton.click();
        return false;
    }
}


// init - called when the page has completed loading
window.onload = init;

function init() {
    // Fire! button onclick handler
    var fireButton = document.getElementById("fireButton");
    fireButton.onclick = handleFireButton;

    // handle "return" key press
    var guessInput = document.getElementById("guessInput");
    guessInput.onkeypress = handleKeyPress;

    // place the ships on the game board
    model.generateShipLocations();
}





