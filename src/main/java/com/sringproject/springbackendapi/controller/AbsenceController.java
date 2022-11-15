package com.sringproject.springbackendapi.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sringproject.springbackendapi.common.AbsencesSpecs;
import com.sringproject.springbackendapi.common.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sringproject.springbackendapi.model.Absences;
import com.sringproject.springbackendapi.repository.AbsencesRepository;

@RestController
@RequestMapping("/api/")
public class AbsenceController {

    @Autowired
    AbsencesRepository absencesRepository;

    @GetMapping("/absences")
    public ResponseEntity<Map<String, Object>> getAllAbsences(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Date endDate,
            @RequestParam(defaultValue = "0") int page
    ) {
        final int SIZE = 10;
        SearchCriteria searchCriteria = new SearchCriteria(status, type, endDate, startDate);

        List<Absences> absences = new ArrayList<Absences>();
        Pageable paging = PageRequest.of(page, SIZE);
        Page<Absences> pageAb = absencesRepository.findAll(AbsencesSpecs.findByCriteria(searchCriteria), paging);

        absences = pageAb.getContent();

        Map<String, Object> res = new HashMap<>();
        res.put("absences", absences);
        res.put("totalPages", pageAb.getTotalPages());

        return new ResponseEntity<>(res, HttpStatus.OK);

    }
}
