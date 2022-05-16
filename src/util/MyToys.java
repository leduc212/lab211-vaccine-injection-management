package util;

import java.util.Scanner;

public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg,
            int lowerBound, int upperBound) {

        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg,
            int lowerBound) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n <= lowerBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg,String errorMsg1,
            double lowerBound, double upperBound) {

        if (lowerBound > upperBound) {
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        double n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new IllegalArgumentException();
                }
                return n;
            } catch (NullPointerException e1) {
                System.out.println(errorMsg1);
            } catch (IllegalArgumentException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, String errorMsg1,
            double lowerBound) {
        double n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n <= lowerBound) {
                    throw new ArithmeticException();
                }
                return n;
            } catch (ArithmeticException e) {
                System.out.println(errorMsg);
            } catch (Exception e) {
                System.out.println(errorMsg1);
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String getId(String inputMsg, String errorMsg, String errorMsg1, String format) {
        boolean match;
        String id;
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else if (!id.matches(format)) {
                System.out.println(errorMsg1);
            } else {
                return id;
            }
        }
    }

    public static String getDate(String inputMsg, String errorMsg) {
        boolean match;
        String format = "^\\d{1,2}[\\/]\\d{1,2}[\\/]\\d{4}$";
        String id;
        while (true) {
            System.out.println(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            String[] parts = id.split("/");
            if (id.length() == 0 || id.isEmpty() || !id.matches(format)) {
                System.out.println(errorMsg);
            } else if (!validDate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]))) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static boolean validDate(int day, int month, int year) {
        if (year >= 1900 && year <= 2099) {
            //check month
            if (month >= 1 && month <= 12) {
                //check days
                if ((day >= 1 && day <= 31) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
                    return true;
                } else if ((day >= 1 && day <= 30) && (month == 4 || month == 6 || month == 9 || month == 11)) {
                    return true;
                } else if ((day >= 1 && day <= 28) && (month == 2)) {
                    return true;
                } else if (day == 29 && month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
