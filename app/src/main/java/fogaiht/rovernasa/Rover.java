package fogaiht.rovernasa;

import android.widget.Toast;

import java.util.Scanner;

/**
 * Created by thiago on 12/02/17.
 */

public class Rover {

    //Atributos
    private String direction;
    protected String command;
    protected int pos_x, pos_y, grid_x, grid_y;
    protected Scanner input;

    //Getters and Setters
    public int getGrid_x() {
        return grid_x;
    }

    public void setGrid_x(int grid_x) {
        this.grid_x = grid_x;
    }

    public int getGrid_y() {
        return grid_y;
    }

    public void setGrid_y(int grid_y) {
        this.grid_y = grid_y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    //Construtores
    public Rover() {
    }

    public Rover(String direction, int pos_x, int pos_y) {
        this.direction = direction;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    //Métodos
    public int action_move(String str) {
        setCommand(str);
        int x = 0;
        int tam = str.length();
        for (int i = 0; i < tam; i++) {
            if ((str.charAt(i) == 'R') || (str.charAt(i) == 'r')) {
                if ("N".equalsIgnoreCase(direction)) {
                    setDirection("E");
                } else if ("S".equalsIgnoreCase(direction)) {
                    setDirection("W");
                } else if ("E".equalsIgnoreCase(direction)) {
                    setDirection("S");
                } else if ("W".equalsIgnoreCase(direction)) {
                    setDirection("N");
                }
                x = 0;
            } else if ((str.charAt(i) == 'L') || (str.charAt(i) == 'l')) {
                if ("N".equalsIgnoreCase(direction)) {
                    setDirection("W");
                } else if ("S".equalsIgnoreCase(direction)) {
                    setDirection("E");
                } else if ("E".equalsIgnoreCase(direction)) {
                    setDirection("N");
                } else if ("W".equalsIgnoreCase(direction)) {
                    setDirection("S");
                }
                x = 0;
            } else if ((str.charAt(i) == 'M') || (str.charAt(i) == 'm')) {
                if ("N".equalsIgnoreCase(direction)) {
                    if (pos_y + 1 > grid_y) {
                        x = 1;
                    } else {
                        pos_y = pos_y + 1;
                        x = 0;
                    }
                } else if ("S".equalsIgnoreCase(direction)) {
                    if (pos_y - 1 < grid_y) {
                        x = 1;
                    } else {
                        pos_y = pos_y - 1;
                        x = 0;
                    }
                } else if ("E".equalsIgnoreCase(direction)) {
                    if (pos_x + 1 > grid_x) {
                        x = 1;
                    } else {
                        pos_x = pos_x + 1;
                        x = 0;
                    }
                } else if ("W".equalsIgnoreCase(direction)) {
                    if (pos_x - 1 < grid_x) {
                        x = 1;
                    } else {
                        pos_x = pos_x - 1;
                        x = 0;
                    }
                }
            } else
                x = 1;
        }
        return x;
    }


    public void inputGrid(int x, int y) {
        setGrid_x(x);
        setGrid_y(y);
    }

    public void insert_status(int X, int Y, String D) {
        setPos_x(X);
        setPos_y(Y);
        setDirection(D);
    }

    public String print_status() {
        return ("(" + getPos_x() + " , " + getPos_y() + " , " + getDirection().toUpperCase() + ")");
    }

    public String print_grid() {
        return ("(" + grid_x + " , " + grid_y + ")");
    }
}
