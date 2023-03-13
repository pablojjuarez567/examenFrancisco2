package com.example.examenjrfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class HelloController {

    @FXML
    private Button anadirAlumno;

    @FXML
    private Button descargarReport;

    @FXML
    private Label media;

    @FXML
    private Label modulosSuspensos;

    @FXML
    private Button salir;

    @FXML
    private TableView<?> tabla;

    @FXML
    private TableColumn<?, ?> tablaAD;

    @FXML
    private TableColumn<?, ?> tablaApellidos;

    @FXML
    private TableColumn<?, ?> tablaDI;

    @FXML
    private TableColumn<?, ?> tablaEIE;

    @FXML
    private TableColumn<?, ?> tablaHLC;

    @FXML
    private TableColumn<?, ?> tablaNombre;

    @FXML
    private TableColumn<?, ?> tablaPMDM;

    @FXML
    private TableColumn<?, ?> tablaPSP;

    @FXML
    private TableColumn<?, ?> tablaSGE;

    @FXML
    private TextField textFieldAD;

    @FXML
    private TextField textFieldApellido;

    @FXML
    private TextField textFieldDI;

    @FXML
    private TextField textFieldEIE;

    @FXML
    private TextField textFieldHLC;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldPMDM;

    @FXML
    private TextField textFieldPSP;

    @FXML
    private TextField textFieldSGE;

    @FXML
    void anadirAlumnoAction(ActionEvent event) {

    }

    @FXML
    void descargarReportAction(ActionEvent event) {
        HashMap hm = new HashMap();


        JasperReport report = JasperCompileManager.compileReport("src/main/resources/reports/asdasdasd.jrxml");

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report,
                hm,
                JDBCconnection.getConnection()
        );

        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Menu.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();
    }

    @FXML
    void salirAction(ActionEvent event) {

    }

    public void initialize() {
        media.setText("");
        modulosSuspensos.setText("");
    }

}
