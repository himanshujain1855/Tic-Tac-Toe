# Function Definitions

# function will return a string
# function will take position of the character and character itself that you want fit in boardstring


def print_board(position=None, character=None, boardstring=None):
    s = boardstring
    s1 = boardstring
    if position == 1:
        s1 = s[0:12] + character + s[13:18]
    elif position == 2:
        s1 = s[0:14] + character + s[15:18]
    elif position == 3:
        s1 = s[0:16] + character + s[17:18]
    elif position == 4:
        s1 = s[0:6] + character + s[7:18]
    elif position == 5:
        s1 = s[0:8] + character + s[9:18]
    elif position == 6:
        s1 = s[0:10] + character + s[11:18]
    elif position == 7:
        s1 = character + s[1:18]
    elif position == 8:
        s1 = s[0:2] + character + s[3:18]
    elif position == 9:
        s1 = s[0:4] + character + s[5:18]
    elif position is None and character is None:
        s1 = s

    return s1


def is_win(board_string):
    # To make easy we need to assign board_string to small name srring
    s = board_string

    # Checking Horizontals
    def hr1():
        if s[0] == s[2]:
            if s[2] == s[4]:
                return True
            else:
                return False
        else:
            return False

    def hr2():
        if s[6] == s[8]:
            if s[8] == s[10]:
                return True
            else:
                return False
        else:
            return False

    def hr3():
        if s[12] == s[14]:
            if s[14] == s[16]:
                return True
            else:
                return False
        else:
            return False

    # Checking Verticals
    def vc1():
        if s[0] == s[6]:
            if s[6] == s[12]:
                return True
            else:
                return False
        else:
            return False

    def vc2():
        if s[2] == s[8]:
            if s[8] == s[14]:
                return True
            else:
                return False
        else:
            return False

    def vc3():
        if s[4] == s[10]:
            if s[10] == s[16]:
                return True
            else:
                return False
        else:
            return False

    # Checking Diagonals
    def dg1():
        if s[0] == s[8]:
            if s[8] == s[16]:
                return True
            else:
                return False
        else:
            return False

    def dg2():
        if s[4] == s[8]:
            if s[8] == s[12]:
                return True
            else:
                return False
        else:
            return False

    if hr1():
        return True
    elif hr2():
        return True
    elif hr3():
        return True
    elif vc1():
        return True
    elif vc2():
        return True
    elif vc3():
        return True
    elif dg1():
        return True
    elif dg2():
        return True
    else:
        return False


def play_ttt():
    board_str = '7|8|9\n4|5|6\n1|2|3\n'
    # player1list is used to check which player is playing at a time
    player1list = [1, 3, 5, 7, 9]
    p1 = input('Which one do you want? x or o')

    if p1 == 'x':
        p2 = 'o'
    elif p1 == 'o':
        p2 = 'x'
    else:
        print('Please enter valid input!')

    print('Player 1 {}\nPlayer 2 {}'.format(p1, p2))
    print("\nLet's Start\n")
    print(board_str)

    for i in range(1, 10):
        if i in player1list:
            print('Player 1 Enter Your Position')
            p = int(input())
            board_str = print_board(p, p1, board_str)
            print(board_str)
            if i > 4:
                if is_win(board_str):
                    print('Congratulations To Player 1 You Won')
                    break
        else:
            print('Player 2 Enter Your Position')
            p = int(input())
            board_str = print_board(p, p2, board_str)
            print(board_str)
            if i > 4:
                if is_win(board_str):
                    print('Congratulations To Player 2 You Won')
                    break


play_ttt()