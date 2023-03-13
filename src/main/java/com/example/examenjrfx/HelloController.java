package com.example.examenjrfx;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import java.sql.SQLException;
import java.text.DecimalFormat;
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
    private TableView<Alumno> tabla;

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

    private ObservableList<Alumno> listaAlumnos;

    @FXML
    void anadirAlumnoAction(ActionEvent event) {

        if(textFieldNombre.getText().isEmpty() || textFieldApellido.getText().isEmpty() ||
                textFieldAD.getText().isEmpty() || textFieldDI.getText().isEmpty() ||
                textFieldEIE.getText().isEmpty() || textFieldHLC.getText().isEmpty() ||
                textFieldPMDM.getText().isEmpty() || textFieldPSP.getText().isEmpty() ||
                textFieldSGE.getText().isEmpty()){
            System.out.println("No se puede dejar ningún campo vacío");
        }else if(Integer.parseInt(textFieldAD.getText()) < 0 || Integer.parseInt(textFieldAD.getText()) > 10 ||
                Integer.parseInt(textFieldDI.getText()) < 0 || Integer.parseInt(textFieldDI.getText()) > 10 ||
                Integer.parseInt(textFieldEIE.getText()) < 0 || Integer.parseInt(textFieldEIE.getText()) > 10 ||
                Integer.parseInt(textFieldHLC.getText()) < 0 || Integer.parseInt(textFieldHLC.getText()) > 10 ||
                Integer.parseInt(textFieldPMDM.getText()) < 0 || Integer.parseInt(textFieldPMDM.getText()) > 10 ||
                Integer.parseInt(textFieldPSP.getText()) < 0 || Integer.parseInt(textFieldPSP.getText()) > 10 ||
                Integer.parseInt(textFieldSGE.getText()) < 0 || Integer.parseInt(textFieldSGE.getText()) > 10){
            System.out.println("Las notas deben estar entre 0 y 10");
        }else{
            String nombre = textFieldNombre.getText();
            String apellido = textFieldApellido.getText();
            Double ad = Double.parseDouble(textFieldAD.getText());
            Double di = Double.parseDouble(textFieldDI.getText());
            Double eie = Double.parseDouble(textFieldEIE.getText());
            Double hlc = Double.parseDouble(textFieldHLC.getText());
            Double pmdm = Double.parseDouble(textFieldPMDM.getText());
            Double psp = Double.parseDouble(textFieldPSP.getText());
            Double sge = Double.parseDouble(textFieldSGE.getText());

            Alumno alumno = new Alumno(nombre, apellido, ad, sge, di, pmdm, psp, eie, hlc);

            tabla.getItems().add(alumno);

            // Limpiar los campos de texto
            textFieldNombre.clear();
            textFieldApellido.clear();
            textFieldAD.clear();
            textFieldDI.clear();
            textFieldEIE.clear();
            textFieldHLC.clear();
            textFieldPMDM.clear();
            textFieldPSP.clear();
            textFieldSGE.clear();
        }

    }

    @FXML
    void descargarReportAction(ActionEvent event) throws JRException, SQLException, ClassNotFoundException {
        pdfReport();
    }

    @FXML
    void salirAction(ActionEvent event) {
        Platform.exit();
    }

    public void initialize() {
        media.setText("");
        modulosSuspensos.setText("");


            listaAlumnos = FXCollections.observableArrayList();
            tabla.setItems(listaAlumnos);

        Alumno alumno = new Alumno("Pablo", "Jimenez",1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
        listaAlumnos.add(alumno);
        alumno = new Alumno("Miguel", "Muñoz",10.0, 6.0, 7.0, 7.0, 5.0, 6.0, 7.0);
        listaAlumnos.add(alumno);
        tabla.refresh();




    }

    public static void pdfReport() throws JRException{

        HashMap hm = new HashMap();


        JasperReport report = JasperCompileManager.compileReport("src/main/resources/reports/pabloExamen.jrxml");

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report,
                hm,
                JDBCutils.getConnection()
        );

        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("Reporte.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();
    }

    public void clickModal(MouseEvent mouseEvent) {

        Alumno alumno = (Alumno) tabla.getSelectionModel().getSelectedItem();
        String texto = "";

        if (alumno == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se ha seleccionado ningún alumno.");
            alert.showAndWait();
            return;
        }

        if(alumno.getAD()>5 && alumno.getDI()>=5 && alumno.getEIE()>=5 && alumno.getHLC()>=5 && alumno.getPMDM()>=5 && alumno.getPSP()>=5 && alumno.getSGE()>=5){
            Double mediaAlumno = (alumno.getAD() + alumno.getDI() + alumno.getEIE() + alumno.getHLC() + alumno.getPMDM() + alumno.getPSP() + alumno.getSGE())/7;

            DecimalFormat formato = new DecimalFormat("#.##");


            texto = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " tiene aprobado todo con una media de " + formato.format(mediaAlumno);
        } else {
            texto = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " tiene suspenso en: ";
            if(alumno.getAD()<=5){
                texto += "AD ";
            }
            if(alumno.getDI()<=5){
                texto += "DI ";
            }
            if(alumno.getEIE()<=5){
                texto += "EIE ";
            }
            if(alumno.getHLC()<=5){
                texto += "HLC ";
            }
            if(alumno.getPMDM()<=5){
                texto += "PMDM ";
            }
            if(alumno.getPSP()<=5){
                texto += "PSP ";
            }
            if(alumno.getSGE()<=5){
                texto += "SGE ";

            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información del alumno");
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}
