package com.TPOO2.funciones;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.TPOO2.models.LugarModel;
import com.TPOO2.models.PermisoDiarioModel;
import com.TPOO2.models.PermisoPeriodoModel;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Funciones {

	public static String encriptarPass(String pass) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(pass);
	}

	public static void generarQR(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
       
    }

	public static String generarUrlPeriodo(PermisoPeriodoModel permisoPeriodoModel){
        LocalDate fin= permisoPeriodoModel.getFecha();
        LocalDate inicio= permisoPeriodoModel.getFecha();
        fin= fin.plusDays(permisoPeriodoModel.getCantDias());
        String fechaFin=fin.getDayOfMonth()+"-"+fin.getMonthValue()+"-"+fin.getYear();
        String fechaInicio = inicio.getDayOfMonth()+"-"+inicio.getMonthValue()+"-"+inicio.getYear();
        List<LugarModel> desdeHasta = new ArrayList<LugarModel>(permisoPeriodoModel.getDesdeHasta());
        return "nombre="+permisoPeriodoModel.getPedido().getNombre()+"&apellido="+permisoPeriodoModel.getPedido().getApellido()+"&dni="+permisoPeriodoModel.getPedido().getDni()+
                "&desde="+desdeHasta.get(0).getLugar()+"&desdeCP="+desdeHasta.get(0).getCodigoPostal()+
                "&hasta="+desdeHasta.get(1).getLugar()+"&hastaCP="+desdeHasta.get(1).getCodigoPostal()
                +"&inicio="+fechaInicio+"&fin="+fechaFin
                +"&vehiculo="+permisoPeriodoModel.getRodado().getVehiculo()+"&dominio="+permisoPeriodoModel.getRodado().getDominio()+"&vacaciones="+permisoPeriodoModel.isVacaciones();

    }


    public static String generarUrlDiario(PermisoDiarioModel permisoDiarioModel) {
        LocalDate inicio= permisoDiarioModel.getFecha();
        String fechaInicio = inicio.getDayOfMonth()+"-"+inicio.getMonthValue()+"-"+inicio.getYear();
        List<LugarModel> desdeHasta = new ArrayList<LugarModel>(permisoDiarioModel.getDesdeHasta());
        return "nombre=" + permisoDiarioModel.getPedido().getNombre() + "&apellido="
                + permisoDiarioModel.getPedido().getApellido() + "&dni=" + permisoDiarioModel.getPedido().getDni()
                + "&desde=" + desdeHasta.get(0).getLugar() + "&desdeCP=" + desdeHasta.get(0).getCodigoPostal()
                + "&hasta=" + desdeHasta.get(1).getLugar() + "&hastaCP=" + desdeHasta.get(1).getCodigoPostal()
                + "&inicio=" + fechaInicio +"&motivo="+permisoDiarioModel.getMotivo();
    }
}