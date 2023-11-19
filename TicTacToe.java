import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class TicTacToe {
    static int number = 0;
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        char[][] base = {
            {
                '1',
                '|',
                '2',
                '|',
                '3'
            },
            {
                '-',
                ' ',
                '-',
                ' ',
                '-'
            },
            {
                '4',
                '|',
                '5',
                '|',
                '6'
            },
            {
                '-',
                ' ',
                '-',
                ' ',
                '-'
            },
            {
                '7',
                '|',
                '8',
                '|',
                '9'
            }
        };
        char[] temp = {
            ' ',
            ' ',
            ' ',
            ' ',
            ' ',
            ' ',
            ' ',
            ' ',
            ' '
        };

        char[] computersymbolarray = {
            '%',
            '$',
            '*',
            '!',
            '^',
            '(',
            ')',
            '@',
            '#',
            '0',
            'O',
            'A',
            '|',
            '+',
            'Z',
            '-',
            '_',
            '~',
            '`',
            'P',
            '/',
            '.',
            '>',
            '<',
            '?'
        };

        int playermove = 0;
        System.out.println("You can chose only 1-9 range.If others,program stop immediatly.");
        Scanner sc = new Scanner(System.in);

        System.out.println("If you have no idea, just enter 0.");
        System.out.println("Choose your symbol.(should be one char)");
        char playerSymbol = sc.next().charAt(0);
        char computersymbol = 'L';
        while (true) {
            int r = (int)(Math.random() * computersymbolarray.length);
            char computerSymbol1 = computersymbolarray[r];
            if (computerSymbol1 != playerSymbol) {
                computersymbol = computerSymbol1;
                break;
            }
        }
        System.out.println(computersymbol + " is for computer");
        System.out.println(playerSymbol + " is for player");
        baseProduction(base, temp);
        int count = 0;
        int ra = (int)(Math.random() * 3);
        int count1 = ra;
        if (isEven(count1)) System.out.println("You move first");
        else System.out.println("Computer move first");
        TimeUnit.SECONDS.sleep(3);
        while (true) {
            if (isEven(count1)) {
                System.out.println("Player Turn------");
                try {
                    int pos = sc.nextInt();



                    if (pos > 9) {
                        String a = String.valueOf(pos);
                        System.out.println("Your movement may mean " + a.charAt(0));
                        pos = Character.getNumericValue(a.charAt(0));
                    }


                    if (pos < 0) {
                        pos *= -1;
                    }
                    if (pos == 0) {
                        for (int i = 1; i <= temp.length; i++) {
                            if (isEmpty(i, temp)) {
                                pos = i;
                            }
                        }
                    }
                    playermove = pos;
                    if (isEmpty(pos, temp)) {
                        switch (pos) {
                            case 1:
                                temp[0] = playerSymbol;
                                break;
                            case 2:
                                temp[1] = playerSymbol;
                                break;
                            case 3:
                                temp[2] = playerSymbol;
                                break;
                            case 4:
                                temp[3] = playerSymbol;
                                break;
                            case 5:
                                temp[4] = playerSymbol;
                                break;
                            case 6:
                                temp[5] = playerSymbol;
                                break;
                            case 7:
                                temp[6] = playerSymbol;
                                break;
                            case 8:
                                temp[7] = playerSymbol;
                                break;
                            case 9:
                                temp[8] = playerSymbol;
                                break;
                        }
                    } else {
                        System.out.println("Space Error !! Try Again !!(Suggest)  Recompile this program");

                        break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Fuck You .Pay attention to the match!!!1");
                }


            } else {
                TimeUnit.SECONDS.sleep(1);
                int computermove;
                int mustwin = mustwin(temp, computersymbol);
                int mustdefend = mustdefend(temp, playerSymbol);
                int pri = prirandom(temp);

                pri = prirandom(temp);

                int random = random(temp);

                random = random(temp);

                if (pri == 999) {
                    computermove = random;
                } else {
                    computermove = pri;
                }


                if (mustwin != 10) {
                    computermove = mustwin;
                } else if (mustdefend != 10) {


                    computermove = mustdefend;
                }

                System.out.println(":::Computer moved to " + computermove);


                if (isEmpty(computermove, temp)) {

                    switch (computermove) {
                        case 1:
                            temp[0] = computersymbol;
                            break;
                        case 2:
                            temp[1] = computersymbol;
                            break;
                        case 3:
                            temp[2] = computersymbol;
                            break;
                        case 4:
                            temp[3] = computersymbol;
                            break;
                        case 5:
                            temp[4] = computersymbol;
                            break;
                        case 6:
                            temp[5] = computersymbol;
                            break;
                        case 7:
                            temp[6] = computersymbol;
                            break;
                        case 8:
                            temp[7] = computersymbol;
                            break;
                        case 9:
                            temp[8] = computersymbol;
                            break;
                    }
                } else {
                    endGame();
                    break;
                }


            }


            baseProduction(base, temp);
            if (checkMagic(temp, playerSymbol)) {
                System.out.println("You won");
                break;
            } else if (checkMagic(temp, computersymbol)) {
                System.out.println("Computer won");
                break;
            }
            count1++;
            count++;
            if (count == 9) {
                System.out.println("Draw");
                break;
            }
        }
    }

    public static boolean isEven(int num) {
        if (num % 2 == 0) return true;
        else return false;
    }
    public static void endGame() {
        System.out.println("Your cannot take already taken place.Try again.");
    }
    public static boolean checkMagic(char[] temp, char symbol) {
        char first = temp[0];
        char second = temp[1];
        char third = temp[2];
        char fourth = temp[3];
        char fifth = temp[4];
        char sixth = temp[5];
        char seventh = temp[6];
        char eighth = temp[7];
        char nineth = temp[8];
        if (first == symbol && second == symbol && third == symbol) {
            return true;
        } else if (first == symbol && fourth == symbol && seventh == symbol) {
            return true;
        } else if (first == symbol && fifth == symbol && nineth == symbol) {
            return true;
        } else if (second == symbol && fifth == symbol && eighth == symbol) {
            return true;
        } else if (third == symbol && sixth == symbol && nineth == symbol) {
            return true;
        } else if (third == symbol && fifth == symbol && seventh == symbol) {
            return true;
        } else if (fourth == symbol && fifth == symbol && sixth == symbol) {
            return true;
        } else if (seventh == symbol && eighth == symbol && nineth == symbol) {
            return true;
        }
        return false;
    }

    public static void baseProduction(char[][] base, char[] temp) {

        base[0][0] = temp[0];
        base[0][2] = temp[1];
        base[0][4] = temp[2];
        base[2][0] = temp[3];
        base[2][2] = temp[4];
        base[2][4] = temp[5];
        base[4][0] = temp[6];
        base[4][2] = temp[7];
        base[4][4] = temp[8];
        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < base[0].length; j++) {
                System.out.print(base[i][j]);
            }
            System.out.println();
        }

    }
    public static boolean isEmpty(int pos, char[] temp) {

        if (temp[pos - 1] == ' ') {
            return true;
        }
        return false;





    }
    public static int mustdefend(char[] temp, char playerSymbol) {
        for (int i = 1; i <= temp.length; i++) {
            if (isEmpty(i, temp)) {
                temp[i - 1] = playerSymbol;
                if (checkMagic(temp, playerSymbol)) {
                    temp[i - 1] = ' ';
                    return i;
                } else temp[i - 1] = ' ';
            }
        }




        return 10;

    }
    public static int mustwin(char[] temp, char computerSymbol) {
        for (int i = 1; i <= temp.length; i++) {
            if (isEmpty(i, temp)) {
                temp[i - 1] = computerSymbol;
                if (checkMagic(temp, computerSymbol)) {
                    temp[i - 1] = ' ';
                    return i;
                } else temp[i - 1] = ' ';
            }
        }

        return 10;
    }

    public static int random(char[] temp) {
        int max = 9;
        int min = 1;
        int randomNum = 1;

        Random rand = new Random();

        randomNum = rand.nextInt((max - min) + 1) + min;

        if (isEmpty(randomNum, temp)) {
            return randomNum;
        } else {

            random(temp);
        }

        for (int i = 1; i <= temp.length; i++) {
            if (isEmpty(i, temp)) {
                return i;
            }
        }
        return 0;


    }
    public static int prirandom(char[] temp) {
        int[] index = {
            1,
            3,
            7,
            9
        };
        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);
        if (isEmpty(5, temp)) {
            return 5;
        } else if (isEmpty(index[randomNum], temp)) {
            return index[randomNum];
        }
        return 999;
    }

}
