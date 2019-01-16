package com.beezen.controller.managerCV.;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.beezen.domain.Utilisateurs;
import com.beezen.exeption.CustomException;
import com.beezen.service.IUtilisateursService;


@CrossOrigin
@RestController
@RequestMapping("/managerCV")
public class ManagerCvController {

    public boolean updateManagerCv () {

        return true;
    }


    public boolean deleteManagerCv(){

        return true;
    }


    public void addManagerCv() {

    }

}