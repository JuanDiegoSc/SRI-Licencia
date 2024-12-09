package com.sriLicencia.microLicencia;

import com.sriLicencia.microLicencia.ModelLicencia;
import com.sriLicencia.microLicencia.ServiceLicencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private ServiceLicencia serviceLicencia;

    @GetMapping("/licencia")
    public ResponseEntity<ModelLicencia> getContribuyente(@RequestParam(value = "cedula") String cedula) {
        try {
            String puntos = serviceLicencia.getApiResponse(cedula);
            return new ResponseEntity<>(new ModelLicencia(puntos), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
