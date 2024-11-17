
package com.almorsan.gimnasio.controllers;

import com.almorsan.gimnasio.dtos.EntrenadorDTO;
import com.almorsan.gimnasio.dtos.SalaDTO;
import com.almorsan.gimnasio.models.Sala;
import com.almorsan.gimnasio.services.SalaEntrenadorService;
import com.almorsan.gimnasio.services.SalaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salas")
public class SalaDTOController {

    @Autowired
    private SalaService salaService;

    @PostMapping
    public Sala crearSala(@RequestBody SalaDTO salaDTO) {
        return salaService.save(salaDTO);
    }
    
     @Autowired
    private SalaEntrenadorService salaEntrenadorService;

    @PostMapping("/{salaId}/entrenadores/{entrenadorId}")
    public Sala addEntrenadorToSala(@PathVariable Long salaId, @PathVariable Long entrenadorId) {
        return salaEntrenadorService.addEntrenadorToSala(salaId, entrenadorId);
    }
    
    
@PatchMapping("/{salaId}")
public ResponseEntity<Sala> actualizarSala(
        @PathVariable Long salaId,
        @RequestBody SalaDTO salaDTO) {
    
    // Llamamos al servicio para actualizar los datos de la sala
    Sala salaActualizada = salaService.actualizarSala(salaId, salaDTO);
    return ResponseEntity.ok(salaActualizada);
}


 @GetMapping("/establecimiento/{establecimientoId}")
    public ResponseEntity<List<Sala>> getSalasByEstablecimiento(@PathVariable Long establecimientoId) {
        List<Sala> salas = salaService.getSalasByEstablecimiento(establecimientoId);
        return ResponseEntity.ok(salas);
    }
}


