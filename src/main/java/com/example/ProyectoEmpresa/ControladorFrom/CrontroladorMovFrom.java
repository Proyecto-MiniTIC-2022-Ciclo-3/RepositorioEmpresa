package com.example.ProyectoEmpresa.ControladorFrom;


import com.example.ProyectoEmpresa.Entidades.Empresas;
import com.example.ProyectoEmpresa.Entidades.Transacciones;
import com.example.ProyectoEmpresa.Servicios.ServicioImpTransacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class CrontroladorMovFrom {

    @Autowired
    private ServicioImpTransacciones sit;

    @GetMapping("/movimientos") // informacion mediante la URL
    public String listar(Model modelo){
        modelo.addAttribute("movimientos", sit.listarTransacciones());
        return ("movimientos");
    }

    @GetMapping("movimientonuevo")
    public String formularioregistro(Model modelo){
        modelo.addAttribute("movimientoinsertar",new Transacciones());
        return "regmovimientos";
    }

    @PostMapping("movimientoguardar")
    public String insertar(Transacciones transaccion){
        sit.guardarTransacciones(transaccion);
        return "redirect:/movimientos";
    }

    @GetMapping("movimientosactualizar/{dato}")
    public String formularioActualizar(@PathVariable("dato") Long dato, Model modelo){
        Transacciones transac=sit.consultarTransaccionesPorID(dato);
        modelo.addAttribute("movimientoactualizar", transac);
        return "actmovimientos";
    }

    @PostMapping("movimientosactualizar")
    public String actualizar(Transacciones transaccion){
        sit.actualizarTransacciones(transaccion);
        return "redirect:/movimientos";
    }

    @GetMapping("movimientoseliminar/{id}")
    public String eliminarporId(@PathVariable("id") Long id){
        sit.eliminarTransaccionesPorId(id);
        return ("redirect:/movimientos");
    }
}
