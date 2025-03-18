import random

# Game Manager Function
def game_manager():
    # Prompt user for their name
    name = input("Enter your name: ")
    print(welcome_message(name))
    
    
    # Define the question bank as a list of strings
    question_bank = [
        "What is the capital of France?|Paris,London,Berlin,Madrid|Paris|Geography",
        "Who won the FIFA World Cup in 2018?|Germany,Argentina,France,Brazil|France|Sports",
        "What is the largest planet in our solar system?|Earth,Jupiter,Saturn,Venus|Jupiter|Science"
    ]

    # Shuffle the questions
    random.shuffle(question_bank)
       
    # Initialize the score and counter
    score = 0
    counter = 0
   
    # Loop through each question in the question bank
    for question_data in question_bank:
        # Counting questions
        counter += 1
        # Call ask_question function 
        is_correct = ask_question(question_data)
        if is_correct:
            score += 1
            
    # Display the user's final score
    print(farewell_message(name, score, counter))

# Display greetings
def welcome_message(name):
    return "Welcome to the Quiz Game, " + name + "! Let's test your knowledge!"

# Display the user's final score
def farewell_message(name, score, counter):
    return "Thanks for playing, " + name + "! You scored " + str(score) + " out of " + str(counter) + ". Well done!"

# Ask Question Function
def ask_question(question_data):
    # Split the question data into parts
    question_parts = question_data.split("|")
    question = question_parts[0]
    options = question_parts[1].split(",")
    correct_answer = question_parts[2]
    category = question_parts[3]

    # Shuffle the options for randomness
    shuffled_options = options[:]
    random.shuffle(shuffled_options)

    # Display the question and options
    print("Category", category)
    print(question)
 
    # Display options manually without enumerate
    for i in range(len(shuffled_options)):
        print(i + 1, shuffled_options[i])

        # Prompt the user for an answer and validate input
    while True:
        answer = input("Enter the number of your answer: ")
        # Check if the input is valid by comparing it to acceptable range values
        if answer in ["1", "2", "3", "4"]:  # Acceptable inputs
            selected_option = shuffled_options[int(answer) - 1]
            if selected_option == correct_answer:
                print("Correct!")
                return True
            else:
                print("Incorrect! The correct answer was", correct_answer, ".")
                return False
        else:
            print("Invalid input. Please enter 1, 2, 3, or 4.")

# Start the game by calling the game manager function
game_manager()
