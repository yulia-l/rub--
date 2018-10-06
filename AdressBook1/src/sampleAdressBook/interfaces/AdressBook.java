package sampleAdressBook.interfaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sampleAdressBook.Person;

public interface AdressBook {

    void add(Person person);
    void update(Person person);
    void delete(Person person);
}
