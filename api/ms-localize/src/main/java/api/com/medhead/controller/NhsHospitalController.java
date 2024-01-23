package api.com.medhead.controller;

import api.com.medhead.model.Hospital;
import api.com.medhead.model.Speciality;
import api.com.medhead.model.SpecialityGroup;
import api.com.medhead.payload.request.PatientSearchRequest;
import api.com.medhead.payload.request.SpecialityGroupRequest;
import api.com.medhead.repository.HospitalRepository;
import api.com.medhead.service.GraphhopperService;
import api.com.medhead.service.HospitalService;
import api.com.medhead.service.SpecialityGroupService;
import api.com.medhead.service.SpecialityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(NhsHospitalController.PATH)
public class NhsHospitalController {

    public static final String PATH = "/api/hospitals";

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private GraphhopperService graphhopperService;
    @Autowired
    private SpecialityGroupService specialityGroupService;

    @Value("${location.search.perimeter.meters}")
    private int locationSearchPerimeterMeters;

    @GetMapping("all")
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }

    @GetMapping("specialities")
    public List<Speciality> getAllSpecialities() {
        return specialityService.getSpecialities();
    }

    @PostMapping("specialities")
    public List<Speciality> getSpecialitiesBySpecialityGroup(@Valid @RequestBody SpecialityGroupRequest specialityGroupRequest) {
        return specialityService.getSpecialitiesBySpecialityGroupId(specialityGroupRequest.getId());
    }

    @GetMapping("speciality-groups")
    public List<SpecialityGroup> getAllSpecialityGroups() {
        return specialityGroupService.getAllSpecialityGroups();
    }

    @GetMapping("perimeter")
    public int getPerimeter(){
        return locationSearchPerimeterMeters;
    }

    @PostMapping("getNearest")
    public List<Hospital> getNearestHospital(@Valid @RequestBody PatientSearchRequest patientSearchRequest){
         return graphhopperService.getNearestHospital(patientSearchRequest, getPerimeter());
    }



}
