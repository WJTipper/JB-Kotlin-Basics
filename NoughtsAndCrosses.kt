package tictactoe

fun main() {
    /* // Stage 1
    println("X O X")
    println("O X O")
    println("X X O")
    */
    
    /* // Stage 2
    val gameState = readLine()!!
    
    println("---------")
    println("| " + gameState[0] + " " + gameState[1] + " " + gameState[2] + " |")
    println("| " + gameState[3] + " " + gameState[4] + " " + gameState[5] + " |")
    println("| " + gameState[6] + " " + gameState[7] + " " + gameState[8] + " |")
    println("---------")
    */
    
    /*
    //Stage 3
    val gameStateStr = readLine()!! // Reads input string
    val gameState = mutableListOf( // Converts input string to 3x3 list
        mutableListOf<Char>(gameStateStr[0], gameStateStr[1], gameStateStr[2]),
        mutableListOf<Char>(gameStateStr[3], gameStateStr[4], gameStateStr[5]),
        mutableListOf<Char>(gameStateStr[6], gameStateStr[7], gameStateStr[8])
    )
    // Prints board in current state
    println("---------")
    println("| " + gameState[0][0] + " " + gameState[0][1] + " " + gameState[0][2] + " |")
    println("| " + gameState[1][0] + " " + gameState[1][1] + " " + gameState[1][2] + " |")
    println("| " + gameState[2][0] + " " + gameState[2][1] + " " + gameState[2][2] + " |")
    println("---------")
    // Creating vars needed for analysing game state
    var xCount: Int = 0
    var oCount: Int = 0
    var emptyCellsRemaining: Boolean
    var xLineOf3: Boolean = false
    var oLineOf3: Boolean = false
    // Counting Xs, Os & empty spaces on the board
    for (i in 0 until gameStateStr.length) {
        if (gameStateStr[i] == 'X') {xCount++}
        if (gameStateStr[i] == 'O') {oCount++}
    }
    if ('_' in gameStateStr) {
        emptyCellsRemaining = true
    } else {
        emptyCellsRemaining = false
    }
    // Checking for lines of 3
    for (i in 0..2) {
        // Checks columns for lines of 3
        if (gameState[0][i] == 'X' && gameState[1][i] == 'X' && gameState[2][i] == 'X') {xLineOf3 = true}
        if (gameState[0][i] == 'O' && gameState[1][i] == 'O' && gameState[2][i] == 'O') {oLineOf3 = true}
        // Checks rows for lines of 3
        if (gameState[i][0] == 'X' && gameState[i][1] == 'X' && gameState[i][2] == 'X') {xLineOf3 = true}
        if (gameState[i][0] == 'O' && gameState[i][1] == 'O' && gameState[i][2] == 'O') {oLineOf3 = true}
    }
    // Checks diagonals for lines of 3
    if (gameState[0][0] == 'X' && gameState[1][1] == 'X' && gameState[2][2] == 'X') {xLineOf3 = true}
    if (gameState[0][2] == 'X' && gameState[1][1] == 'X' && gameState[0][2] == 'X') {xLineOf3 = true}
    if (gameState[0][0] == 'O' && gameState[1][1] == 'O' && gameState[2][2] == 'O') {oLineOf3 = true}
    if (gameState[0][2] == 'O' && gameState[1][1] == 'O' && gameState[0][2] == 'O') {oLineOf3 = true}
    // Evaluating current game result
    var gameResult: String
    if ((xCount - oCount > 1 || xCount - oCount < -1) || (xLineOf3 == true && oLineOf3 == true)) {gameResult = "Impossible"}
    else if (emptyCellsRemaining == true && xLineOf3 == false && oLineOf3 == false) {gameResult = "Game not finished"}
    else if (emptyCellsRemaining == false && xLineOf3 == false && oLineOf3 == false) {gameResult = "Draw"}
    else if (xLineOf3 == true && oLineOf3 == false) {gameResult = "X wins"}
    else if (xLineOf3 == false && oLineOf3 == true) {gameResult = "O wins"}
    else {gameResult = "Not sure, halp!"}
    
    println(gameResult)
    */
    /*
    // Stage 4
    val gameStateStr = readLine()!! // Reads input string
    val gameState = mutableListOf( // Converts input string to 3x3 list
        mutableListOf<Char>(gameStateStr[0], gameStateStr[1], gameStateStr[2]),
        mutableListOf<Char>(gameStateStr[3], gameStateStr[4], gameStateStr[5]),
        mutableListOf<Char>(gameStateStr[6], gameStateStr[7], gameStateStr[8])
    )
    // Prints board in current state
    println("---------")
    println("| " + gameState[0][0] + " " + gameState[0][1] + " " + gameState[0][2] + " |")
    println("| " + gameState[1][0] + " " + gameState[1][1] + " " + gameState[1][2] + " |")
    println("| " + gameState[2][0] + " " + gameState[2][1] + " " + gameState[2][2] + " |")
    println("---------")
    // Asks user to enter coordinates & converts to 2 characters
    var coordList = mutableListOf<String>()
    var coord1: Char
    var coord2: Char
    var coord1Num: Int
    var coord2Num: Int
    var coordsOk: Boolean = false
    // Checks if the entered coordinates are valid (i.e. numbers corresponding to an empty cell)
    do {
        println("Enter the coordinates:")
        coordList = readLine()!!.split(" ").toMutableList()
        coord1 = coordList[0].first()
        coord2 = coordList[1].first()
        coord1Num = coord1.digitToInt()
        coord2Num = coord2.digitToInt()
        if (coord1.toInt() !in 48..57 || coord2.toInt() !in 48..57) { // Checks if coords are numerical
            println("You should enter numbers!")
        } else if (coord1Num !in 1..3 || coord2Num !in 1..3) { // Checks that coords are 1, 2 or 3
            println("Coordinates should be from 1 to 3!")
        } else if (gameState[coord1Num - 1][coord2Num - 1] == 'X' || gameState[coord1Num - 1][coord2Num - 1] == 'O') {
            // Checks if cell is already occupied by X or O
            println("This cell is occupied! Choose another one!")
        } else {
            coordsOk = true
        }
    } while (coordsOk == false)
    // Updates the current state of the board & prints it
    gameState[coord1Num - 1][coord2Num - 1] = 'X'
    println("---------")
    println("| " + gameState[0][0] + " " + gameState[0][1] + " " + gameState[0][2] + " |")
    println("| " + gameState[1][0] + " " + gameState[1][1] + " " + gameState[1][2] + " |")
    println("| " + gameState[2][0] + " " + gameState[2][1] + " " + gameState[2][2] + " |")
    println("---------")
    */
    
    // Stage 5
    // 1. Print  an empty grid
    // 2. Game loop: user asked for cell coordinates, analyzes move for correctness, shows grid with changes if move is okay
    // 3. End the game when someone wins or there is a draw
    
    val gameState = mutableListOf( // Initial game state: empty board
        mutableListOf<Char>(' ', ' ', ' '),
        mutableListOf<Char>(' ', ' ', ' '),
        mutableListOf<Char>(' ', ' ', ' ')
    )
    println("---------")
    println("| " + gameState[0][0] + " " + gameState[0][1] + " " + gameState[0][2] + " |")
    println("| " + gameState[1][0] + " " + gameState[1][1] + " " + gameState[1][2] + " |")
    println("| " + gameState[2][0] + " " + gameState[2][1] + " " + gameState[2][2] + " |")
    println("---------")
    
    var gameResult = "Game not finished"
    var coordList = mutableListOf<String>()
    var coord1: Char
    var coord2: Char
    var coord1Num: Int
    var coord2Num: Int
    var coordsOk: Boolean = false
    var turnCounter = 0
    var xCount: Int = 0
    var oCount: Int = 0
    var emptyCellsRemaining: Boolean
    var xLineOf3: Boolean = false
    var oLineOf3: Boolean = false
    
    // Game loop
    while (gameResult == "Game not finished") {
    
        // Checks if the entered coordinates are valid (i.e. numbers corresponding to an empty cell)
        coordsOk = false
        do {
            println("Enter the coordinates:")
            coordList = readLine()!!.split(" ").toMutableList()
            coord1 = coordList[0].first()
            coord2 = coordList[1].first()
            coord1Num = coord1.digitToInt()
            coord2Num = coord2.digitToInt()
            if (coord1.toInt() !in 48..57 || coord2.toInt() !in 48..57) { // Checks if coords are numerical
                println("You should enter numbers!")
            } else if (coord1Num !in 1..3 || coord2Num !in 1..3) { // Checks that coords are 1, 2 or 3
                println("Coordinates should be from 1 to 3!")
            } else if (gameState[coord1Num - 1][coord2Num - 1] == 'X' || gameState[coord1Num - 1][coord2Num - 1] == 'O') {
                // Checks if cell is already occupied by X or O
                println("This cell is occupied! Choose another one!")
            } else {
                coordsOk = true
            }
        } while (coordsOk == false)
        
        // Updates the current state of the board depending on whose turn it is & prints it
        if (turnCounter % 2 == 0) {
            gameState[coord1Num - 1][coord2Num - 1] = 'X'
        } else {
            gameState[coord1Num - 1][coord2Num - 1] = 'O'
        }
        turnCounter++
        println("---------")
        println("| " + gameState[0][0] + " " + gameState[0][1] + " " + gameState[0][2] + " |")
        println("| " + gameState[1][0] + " " + gameState[1][1] + " " + gameState[1][2] + " |")
        println("| " + gameState[2][0] + " " + gameState[2][1] + " " + gameState[2][2] + " |")
        println("---------")
        
        // Evaluating game result
        xCount = 0
        oCount = 0
        for (i in 0..2) { // Counting Xs, Os & empty spaces on the board
            for (j in 0..2) {
                if (gameState[i][j] == 'X') {xCount++}
                if (gameState[i][j] == 'O') {oCount++}
            }
        }
        if (' ' in gameState[0] || ' ' in gameState[1] || ' ' in gameState[2]) {
            emptyCellsRemaining = true
        } else {
            emptyCellsRemaining = false
        }
        for (i in 0..2) { // Checking for lines of 3
            // Checks columns for lines of 3
            if (gameState[0][i] == 'X' && gameState[1][i] == 'X' && gameState[2][i] == 'X') {xLineOf3 = true}
            if (gameState[0][i] == 'O' && gameState[1][i] == 'O' && gameState[2][i] == 'O') {oLineOf3 = true}
            // Checks rows for lines of 3
            if (gameState[i][0] == 'X' && gameState[i][1] == 'X' && gameState[i][2] == 'X') {xLineOf3 = true}
            if (gameState[i][0] == 'O' && gameState[i][1] == 'O' && gameState[i][2] == 'O') {oLineOf3 = true}
        }
        // Checks diagonals for lines of 3
        if (gameState[0][0] == 'X' && gameState[1][1] == 'X' && gameState[2][2] == 'X') {xLineOf3 = true}
        if (gameState[0][2] == 'X' && gameState[1][1] == 'X' && gameState[2][0] == 'X') {xLineOf3 = true}
        if (gameState[0][0] == 'O' && gameState[1][1] == 'O' && gameState[2][2] == 'O') {oLineOf3 = true}
        if (gameState[0][2] == 'O' && gameState[1][1] == 'O' && gameState[2][0] == 'O') {oLineOf3 = true}
        // Evaluating current game result
        if ((xCount - oCount > 1 || xCount - oCount < -1) || (xLineOf3 == true && oLineOf3 == true)) {
            gameResult = "Impossible"
            break
        }
        else if (emptyCellsRemaining == true && xLineOf3 == false && oLineOf3 == false) {
            gameResult = "Game not finished"
        }
        else if (emptyCellsRemaining == false && xLineOf3 == false && oLineOf3 == false) {
            gameResult = "Draw"
            break
        }
        else if (xLineOf3 == true && oLineOf3 == false) {
            gameResult = "X wins"
            break
        }
        else if (xLineOf3 == false && oLineOf3 == true) {
            gameResult = "O wins"
            break
        }
        else {
            gameResult = "Not sure, halp!"
            break
        }
    }
    
    println(gameResult)
}
