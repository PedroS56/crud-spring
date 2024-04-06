package com.example.crudspring;

import org.springframework.web.bind.annotation.RestController;

import com.example.crudspring.models.Trole;
import com.example.crudspring.models.Tusuario;
import com.example.crudspring.repository.TroleRepository;
import com.example.crudspring.repository.TusuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class Controller {

    @Autowired
    TroleRepository troleRepository;

    @Autowired
    TusuarioRepository tusuarioRepository;

    private Controller(TroleRepository troleRepository, TusuarioRepository tusuarioRepository) {
        this.troleRepository = troleRepository;
        this.tusuarioRepository = tusuarioRepository;
    }

    
    // ************************
    // Endpoints for Trole
    // ************************
    @GetMapping("/troles")
    public ResponseEntity<List<Trole>> getAllTroles(@RequestParam(required = false) String nombre) {
        try {
            List<Trole> troles = new ArrayList<Trole>();

            if (nombre == null)
                troleRepository.findAll().forEach(troles::add);
            else
                troleRepository.findByNombreContaining(nombre).forEach(troles::add);

            if (troles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(troles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/trole/{id}")
    public ResponseEntity<Trole> getTroleById(@PathVariable("id") int id) {

        Optional<Trole> troleOptional = troleRepository.findById(id);

        if (troleOptional.isPresent())
            return new ResponseEntity<>(troleOptional.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/troles")
    public ResponseEntity<Trole> createTrole(@RequestBody Trole trole) {
        try {
            Trole myTrole = troleRepository.save(new Trole(trole.getNombre()));
            return new ResponseEntity<>(myTrole, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/trole/edit/{id}")
    public ResponseEntity<Trole> putMethodName(@PathVariable("id") int id, @RequestBody Trole trole) {
        Optional<Trole> troleOptional = troleRepository.findById(id);

        if (troleOptional.isPresent()) {
            Trole myTrole = troleOptional.get();
            if (trole.getNombre() != null) 
                myTrole.setNombre(trole.getNombre());
            return new ResponseEntity<>(troleRepository.save(myTrole), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/trole/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTrole(@PathVariable("id") int id) {
        try {
            troleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ************************
    // Endpoints for Tusuario
    // ************************

    @GetMapping("/tusuarios")
    public ResponseEntity<List<Tusuario>> getAllTusuarios(@RequestParam(required = false) String nombre) {
        try {
            List<Tusuario> tusuarios = new ArrayList<Tusuario>();

            if (nombre == null)
                tusuarioRepository.findAll().forEach(tusuarios::add);
            else
                tusuarioRepository.findByNombreContaining(nombre).forEach(tusuarios::add);

            if (tusuarios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tusuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tusuario/{id}")
    public ResponseEntity<Tusuario> gettusuarioById(@PathVariable("id") int id) {
        Optional<Tusuario> tusuarioOptional = tusuarioRepository.findById(id);

        if (tusuarioOptional.isPresent())
            return new ResponseEntity<>(tusuarioOptional.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/tusuarios")
    public ResponseEntity<Tusuario> createTusuario(@RequestBody Tusuario tusuario) {
        try {
            Tusuario myTusuario = tusuarioRepository.save(new Tusuario(
                    tusuario.getNombre(),
                    tusuario.getA_paterno(),
                    tusuario.getA_materno(),
                    tusuario.getId_trole()));
            return new ResponseEntity<>(myTusuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/tusuario/edit/{id}")
    public ResponseEntity<Tusuario> putMethodName(@PathVariable("id") int id, @RequestBody Tusuario tusuario) {
        Optional<Tusuario> tusuarioOptional = tusuarioRepository.findById(id);

        if (tusuarioOptional.isPresent()) {
            Tusuario myTusuario = tusuarioOptional.get();
            if(tusuario.getNombre() != null) 
                myTusuario.setNombre(tusuario.getNombre()) ;
            if(tusuario.getA_paterno() != null) 
                myTusuario.setA_paterno(tusuario.getA_paterno());
            if(tusuario.getA_materno() != null) 
                myTusuario.setA_materno(tusuario.getA_materno());
            if(tusuario.getId_trole() != 0) 
                myTusuario.setId_trole(tusuario.getId_trole());
            return new ResponseEntity<>(tusuarioRepository.save(myTusuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tusuario/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTusuario(@PathVariable("id") int id) {
        try {
            tusuarioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}