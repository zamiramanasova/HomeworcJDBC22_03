package org.example.test;

import org.example.database.Util;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Util.connection();

        TableMayors tableMayors = new TableMayors();
        TableMayors.connection();


        TableCity tableCity = new TableCity();
        TableCity.connection();

        TableCountry tableCountry = new TableCountry();
        TableCountry.connection();

        TableMayors.addMayors(1,"Мэр", "Вячеслав Доронин", 45);
        TableMayors.addMayors(2,"Мэр", "Джи Ли", 55);
        TableMayors.addMayors(3,"Мэр", "Дэвид Паттерс", 61);
        TableMayors.addMayors(4,"Мэр", "Бекмуралы Догордиев", 47);
        TableMayors.addMayors(5,"Мэр", "Янлис Шмуле", 51);

        TableCity.addCity(1,"Калининград", 767, 1200000,1);
        TableCity.addCity(2,"Шенчжень", 35, 23000000,2);
        TableCity.addCity(3,"Техас", 177, 22000000,3);
        TableCity.addCity(4,"Улан-Батор", 244, 6300000,4);
        TableCity.addCity(5,"Варшава", 426, 9200000,5);

        TableCountry.addCountry(1,"Россия", "Евразия", "рубль",1);
        TableCountry.addCountry(2,"Китай", "Евразия", "юань",2);
        TableCountry.addCountry(3,"США", "Северная Америка", "американский доллар",3);
        TableCountry.addCountry(4,"Монголия", "Евразия", "тугрик",4);
        TableCountry.addCountry(5,"Польша", "Евразия", "польский злотый",5);

        TableMayors.getAllMayors();
        TableCity.getAllCity();
        TableCountry.getAllCountry();

    }
}
