package sampleAdressBook.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sampleAdressBook.Person;
import sampleAdressBook.interfaces.AdressBook;

import java.util.ArrayList;

public class CollectionAdressBook implements AdressBook{

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) { personList.add(person);}

    @Override
    public void update(Person person) {    }

    @Override
    public void delete(Person person) { personList.remove(person);}

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void print(){
        int number = 0;
        System.out.println();
        for (Person person : personList){
            number++;
            System.out.println(number + ") " + person.toString());
        }
    }

    public void fillTestData(){
        personList.add(new Person("Иван", "Иванов", "89151111111"));
        personList.add(new Person("Петр", "Петров", "89152222222"));
        personList.add(new Person("Алексей", "Сидоров", "89153333333"));
        personList.add(new Person("Мария", "Пупкина", "89154444444"));
        personList.add(new Person("Светлана", "Галкина", "89155555555"));
    }
}
