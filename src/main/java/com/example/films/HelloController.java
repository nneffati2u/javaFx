package com.example.films;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rang.setCellValueFactory(new PropertyValueFactory<Film, Integer>("rang"));
        identifiant.setCellValueFactory(new PropertyValueFactory<Film, String>("identifiant"));
        nom.setCellValueFactory(new PropertyValueFactory<Film, String>("nom"));
        année.setCellValueFactory(new PropertyValueFactory<Film, Integer>("année"));
        acteurPrincipal.setCellValueFactory(new PropertyValueFactory<Film, String>("acteurPrincipal"));

    }

    public void ajouterFilmDansTableau(Integer rang, String id, String nom, Integer annee, String acteurPrincipal) {
        Film film = new Film();
        film.setRang(rang);
        film.setIdentifiant(id);
        film.setNom(nom);
        film.setAnnée(annee);
        film.setActeurPrincipal(acteurPrincipal);

        ObservableList<Film> films = tableau.getItems();
        films.add(film);
        tableau.setItems(films);
    }
    public List<List<String>> getCsv() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("movies.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return records;
    }


    @FXML
    private TableColumn rang;
    @FXML
    private TableColumn identifiant;
    @FXML
    private TableColumn nom;
    @FXML
    private TableColumn année;
    @FXML
    private TableColumn acteurPrincipal;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnImporter;

    @FXML
    private TableView tableau;
    @FXML
    private TextField textRang;
    @FXML
    private TextField textId;
    @FXML
    private TextField textNom;
    @FXML
    private TextField textAnnee;
    @FXML
    private TextField textActeur;

    @FXML
    private void ajouterFilm() {
        ajouterFilmDansTableau(
                Integer.parseInt(textRang.getText()),
                textId.getText(),
                textNom.getText(),
                Integer.parseInt(textAnnee.getText()),
                textActeur.getText()
        );

    }

    @FXML
    private void viderTableau() {
        tableau.getItems().clear();
    }

    @FXML
    private void supprimerFilm(){
        ObservableList<Film> films = tableau.getItems();
        films.remove(tableau.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void importerFilms(){
        List<List<String>> csv = getCsv();
        for (int i = 1; i < csv.size(); i++) {
            Film films = new Film();
            ajouterFilmDansTableau(Integer.parseInt(csv.get(i).get(0)), csv.get(i).get(1)+"", csv.get(i).get(2)+"", Integer.parseInt(csv.get(i).get(3)), csv.get(i).get(10)+"");
                    //Integer.parseInt(csv.get(i).get(3));

            //films.setActeurPrincipal(csv.get(i).get(10));
            //tableau.getItems().add(films);

        }


    }



}