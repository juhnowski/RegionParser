/**
 * https://developers.google.com/analytics/devguides/collection/protocol/v1/geoid - лучший.
записи в csv имеет переменное число полей, но только из-за одного поля Canonical Name:
Criteria ID - для монги это будет _id
Name
официальное название
Canonical Name - поле переменной длины
есть предложение парсить следующим образом:
первое поле - совпадает с Name
последнее поле - совпадает с названием страны
все что осталось - третье поле (аналог нашего почтового адреса). Для типа DMA Region строка парсится на 12 полей - вопрос нужен ли такой тип? мое предложение убрать(непонятная ссылка про DMA - http://www.stssamples.com/dma-codes.asp)
Parent ID - дерево регионов, вопрос нужно оно нам или нет....
Country Code
ISO-3166-1 alpha-2 - уже есть для Visa
Target Type - чаще всего City
Airport
Autonomous Community
Borough
Canton
City
City Region
Congressional District
Country
County
Department
District
DMA Region
Governate
Municipality
Neighborhood
Okrug
Postal Code
Prefecture
Province
Region
State
Territory
TV Region
Union Territory
University
Status
Active - Location is currently valid.
Removal Planned - Location is obsolete and will be removed in the next version.
Предлагаю сделать таблицы и в MongoDB для автокомплита и в PostgreSQL - для геолокации платежных систем.
 */
package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    public void run() {

        String csvFile = "D:\\src_region\\region.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
int cnt = 0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] country = line.split(cvsSplitBy);
if(country.length > 11){
    System.out.println(country[0].toString());
    System.out.println(country[1].toString());
    System.out.println(country[2].toString());
    System.out.println(country[3].toString());
    System.out.println(country[4].toString());
    System.out.println(country[5].toString());
    System.out.println(country[6].toString());
    System.out.println(country[7].toString());
    System.out.println(country[8].toString());
    System.out.println(country[9].toString());
    System.out.println(country[10].toString());
    System.out.println(country[11].toString());
    System.out.println("-------------------------------");
    cnt++;
}

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("cnt="+cnt);
    }

    public static void main(String[] args) {
        Parser obj = new Parser();
        obj.run();
    }

}
