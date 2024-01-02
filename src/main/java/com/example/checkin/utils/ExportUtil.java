package com.example.checkin.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class ExportUtil {
    public static void exportReport(InputStream inputStream, OutputStream outputStream, Map<String, Object> parameters,
                                    List<?> exportList, String type) throws JRException, URISyntaxException {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
        JRDataSource dataSource = (JRDataSource) createJRDataSource(exportList);
//    	JRDataSource dataSource = new JRBeanCollectionDataSource(exportList);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        export(jasperPrint, type, outputStream);
    }

    public static Object createJRDataSource( List<?> data) {
        return data != null && data.size() > 0 ? new JRBeanCollectionDataSource(data) : new JREmptyDataSource();
    }

    public static void export(JasperPrint jasperPrint, String type, OutputStream outputStream) throws JRException, URISyntaxException {
        switch (type) {
            case "pdf":
                exportPDF(jasperPrint, outputStream);
                break;
            case "docx":
                exportDOCX(jasperPrint, outputStream);
                break;
            case "xlsx":
                exportXLSX(jasperPrint, outputStream);
                break;
            default:
                throw new JRException("System not suport export reports type " + type);
        }
    }

    private static void exportPDF(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.setConfiguration(new SimplePdfReportConfiguration());
        exporter.exportReport();
    }

    private static void exportDOCX(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.setConfiguration(new SimpleDocxReportConfiguration());
        exporter.exportReport();
    }

    private static void exportXLSX(JasperPrint jasperPrint, OutputStream outputStream) throws JRException {
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(Boolean.FALSE);
        configuration.setDetectCellType(Boolean.TRUE);
        configuration.setCollapseRowSpan(Boolean.FALSE);
        configuration.setWhitePageBackground(Boolean.FALSE);
        configuration.setRemoveEmptySpaceBetweenRows(Boolean.FALSE);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
    }
}
