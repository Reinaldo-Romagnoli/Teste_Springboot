package com.api.cliniconect.controllers;

import com.api.cliniconect.dtos.PacientsDto;
import com.api.cliniconect.models.PacientsModel;
import com.api.cliniconect.services.PacientsService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pacients")
public class PacientsController {

    final PacientsService pacientsService;

    public PacientsController(PacientsService pacientsService) {
        this.pacientsService = pacientsService;
    }

    @PostMapping
    public ResponseEntity<Object> savePacients(@RequestBody @Valid PacientsDto pacientsDto){
        if(pacientsService.existsByLicenseCpf(pacientsDto.getLincenseCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Cpf already in use!");
        }
        if(pacientsService.existsByLicenseEmail(pacientsDto.getLincenseEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Email already in use!");
        }
        var pacientsModel = new pacientsModel();
        BeanUtils.copyProperties(pacientsDto, pacientsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacientsService.save(pacientsModel));
    }

    @GetMapping
    public ResponseEntity<List<PacientsModel>> getAllPacients(){
        return ResponseEntity.status(HttpStatus.OK).body(pacientsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePacients(@PathVariable(value = "id") UUID id){
        Optional<PacientsModel> pacientsModelOptional = pacientsService.findById(id);
        if (!pacientsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacient not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacientsModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePacients(@PathVariable(value = "id") UUID id){
        Optional<PacientsModel> pacientsModelOptional = pacientsService.findById(id);
        if (!pacientsModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacient not found.");
        }
        pacientsService.delete(pacientsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(pacientsModelOptional.get("Pacient deleted seccessfuly."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePacients(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid PacientsDto pacientsDto){
        Optional<PacientsModel> pacientsModelOptional = pacientsService.findById(id);
        if (!pacientsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pacient not found.");
        }
        var pacientsModel:PacientsModel = pacientsModelOptional.get();
        pacientsModel.setPacientsName(pacientsDto.getPacientsName());
        pacientsModel.setPacientsSex(pacientsDto.getPacientsSex());
        pacientsModel.setPacientsAdress(pacientsDto.getPacientsAdress());
        pacientsModel.setPacientsCpf(pacientsDto.getPacientsCpf());
        pacientsModel.setPacientsTellphone(pacientsDto.getPacientsTellphone());
        pacientsModel.setPacientsBirth_date(pacientsDto.getPacientsBirth_date());
        pacientsModel.setPacientsEmail(pacientsDto.getPacientsEmail());
        pacientsModel.setPacientsService_information(pacientsDto.getPacientsService_information());
        return ResponseEntity.status(HttpStatus.OK).body(pacientsService.save(pacientsModel));
    }
}
