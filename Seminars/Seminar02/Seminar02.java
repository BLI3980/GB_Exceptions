package Seminars.Seminar02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Seminar02 {
    public static void main(String[] args) {
        /*
        Обработайте возможные исключительные ситуации. "Битые" значения в исходном массиве
        считайте нулями. Можно внести в код правки, которые считаете необходимыми.
         */
//        String[][] array = {{"-4", "0", "2"}, {"-1", "9", "0"}, {"34", "-22", "0"}};
//        System.out.println("Sum of array values: " + sumZeros(array));


        /*
        Запишите в файл следующие строки:
        Анна=4
        Елена=5
        Марина=6
        Владимир=?
        Константин=?
        Иван=4
        Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
        (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти
        по структуре данных, если сохранено значение "?", заменить его на соответствующее число.
        Если на каком-то месте встречается символ, отличный от числа или "?", бросить
        подходящее исключение. Записать в тот же файл данные с замененными символами "?".
         */
        File file = new File("./Seminars/Seminar02/dataFile.csv");
        System.out.println(file.getAbsolutePath());
        HashMap<String, String > map =  readFileIntoHashmap(file);
        System.out.println();
        map.forEach((k, v) -> System.out.println(k + "=" + v));
        HashMap<String, Integer> map1 = editHashmap(map);
        System.out.println();
        map1.forEach((k, v) -> System.out.println(k + "=" + v));
        String file1 = "./Seminars/Seminar02/dataFile1.csv";
//        File file1 = new File("./Seminars/Seminar02/dataFile1.csv");
        writeHashmapToFile(map1, file1);

        // ==========================================================================
        // Seminar code:
        String file2 = "./Seminars/Seminar02/dataFile2.csv";
        readFileAndCreateHashMap(file2);

    }

    public static int sumZeros(String[][] array) {
        int sum = 0;
        int value;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try{
                    value = Integer.parseInt(array[i][j]);
                    if (value == 0) {
                        throw new RuntimeException("Error: bad value at index ["
                                + i + "][" + j + "].");
                    }
                    sum += value;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
//                    System.out.printf("Error: bad value at index [%d][%d].\n", i, j);
                }
            }
        }
        return sum;
    }

    public static HashMap<String, String> readFileIntoHashmap(File file) {
        HashMap<String, String> map = new HashMap<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            if (line != null) {
                while (line != null) {
                    try{
                        System.out.println(line);
                        String key = line.split("=")[0];
                        String value = line.split("=")[1];
                        if (!value.equals("?") && !isNumeric(value)) {
                            throw new RuntimeException("Value is neither a number nor a \"?\" sign. ");
                        }
                    } catch (RuntimeException e) {
                        System.out.println("Runtime exception: " + e.getMessage());
                    } finally {
                        map.put(line.split("=")[0],line.split("=")[1]);
                        line = bufferedReader.readLine();
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error:" + e.getMessage());
        }
        return map;
    }

    public static boolean isNumeric(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static HashMap<String, Integer> editHashmap(HashMap<String, String> input) {
        HashMap<String, Integer> result = new HashMap<>();
        input.forEach((k, v) -> fillHashMap(result, k, v));
        return result;
    }

    private static void fillHashMap(HashMap<String, Integer> resultMap, String k, String v) {
        if (v.equals("?")) {
            resultMap.put(k, -1);

        } else if (!isNumeric(v)) {
            resultMap.put(k, -2);
        } else {
            int temp = Integer.parseInt(v);
            resultMap.put(k, temp);
        }
    }

    public static void writeHashmapToFile(HashMap<String, Integer> input, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            input.forEach((k, v) -> {
                try {
                    fileWriter.write(k + " = " + v);
                    fileWriter.append("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Write to file exception: " + e.getMessage());
        }

    }


    // ==========================================================================
    // Seminar code:
    public static void readFileAndCreateHashMap(String file) {
        HashMap<String, Integer> dataFile = new HashMap<>();
        try {
            FileReader inputData = new FileReader(file);
            BufferedReader reader = new BufferedReader(inputData);
            try {
                String data = reader.readLine();
                if (data != null) {
                    while (data != null) {
                        if (!data.split("=")[1].equals("?") && !isNumberic(data.split("=")[1])){
                            throw new RuntimeException("Not digit and not '?'");
                        }
                        if ("?".equals(data.split("=")[1])) {
                            dataFile.put(data.split("=")[0], 100);
                        } else {
                            dataFile.put(data.split("=")[0], Integer.parseInt(data.split("=")[1]));
                        }
                        data = reader.readLine();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(dataFile);
        try {
            writeHashMapToFile(file,dataFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static boolean isNumberic(String data){
        int result = 0;
        try{
            result = Integer.parseInt(data);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static void writeHashMapToFile(String fileName, HashMap<String, Integer> data) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(fileName));

        for (String key : data.keySet()) {
            Integer value = data.get(key);

            if (value == null) {
                writer.println(key + "=?");
            } else {
                writer.println(key + "=" + value);
            }
        }

        writer.close();
    }
}
