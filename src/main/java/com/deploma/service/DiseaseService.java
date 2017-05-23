package com.deploma.service;

import com.deploma.dao.*;
import com.deploma.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class DiseaseService {
    private final DiseaseDao diseaseDao;
    private final SymptomDao symptomDao;
    private final DoctorDao doctorDao;
    private final GroupOfDiseasesDao groupOfDiseasesDao;
    private final RoomDao roomDao;
    private final UserDao userDao;
    private final RentDao rentDao;
    private final RoleDao roleDao;

    @Autowired
    public DiseaseService(DiseaseDao diseaseDao, SymptomDao symptomDao, DoctorDao doctorDao, GroupOfDiseasesDao groupOfDiseasesDao, RoomDao roomDao, UserDao userDao, RentDao rentDao, RoleDao roleDao) {
        this.diseaseDao = diseaseDao;
        this.symptomDao = symptomDao;
        this.doctorDao = doctorDao;
        this.groupOfDiseasesDao = groupOfDiseasesDao;
        this.roomDao = roomDao;
        this.userDao = userDao;
        this.rentDao = rentDao;
        this.roleDao = roleDao;
    }

    public Set<Disease> search(String symp) {
        String[] symptomsStrings = symp.trim().split("\\p{P}?[ \\t\\n\\r]+");
        Set<Symptom> symptoms = new HashSet<>();
        for (String s : symptomsStrings) {
            Symptom symptom = symptomDao.getSymptomByName(s);
            symptoms.add(symptom);
        }
        return diseaseDao.findBySymptomsIsIn(symptoms);
    }

    public void test() {
        List<Role> roles =  new ArrayList<>();
        Role role = new Role();
        role.setType("USER");
        roleDao.save(role);
        roles.add(role);
        List<Rent> rents = new ArrayList<>();
        User user = new User();
        user.setUsername("ivanovivan");
        user.setLastName("Ivanov");
        user.setRoles(roles);
        user.setPassword("qwerty");
        user.setFirstName("First Name");
        userDao.save(user);
        Rent rent = new Rent();
        rent.setDate(new Date().toString());
        Room room = new Room();
        room.setNumber(1);
        roomDao.save(room);
        Doctor doctor =  new Doctor();
        doctor.setLastName("Petrov");
        doctor.setFirstName("Petr");
        doctor.setRoom(room);
        doctorDao.save(doctor);
        rent.setDoctor(doctor);
        rent.setUser(user);
        rentDao.save(rent);
        rents.add(rent);
        user.setRents(rents);
        userDao.save(user);
        GroupOfDiseases groupOfDiseases = new GroupOfDiseases();
        groupOfDiseases.setName("Acute respiratory viral infection");
        groupOfDiseases.setDoctor(doctor);
        groupOfDiseasesDao.save(groupOfDiseases);
        Symptom symptom = new Symptom();
        symptom.setName("temperature");
        symptomDao.save(symptom);
        Symptom symptom1 = new Symptom();
        symptom1.setName("cough");
        symptomDao.save(symptom1);
        Symptom symptom2 = new Symptom();
        symptom2.setName("weakness");
        symptomDao.save(symptom2);
        Disease disease = new Disease();
        disease.setGroupsOfDiseases(groupOfDiseases);
        disease.setDescription("Cooling the body or parts of the body, which is the cause of various diseases. In non-medical sources, the common cold is also called a cold, caused by the cooling of the body");
        Set<Symptom> symptomList = new HashSet<>();
        symptomList.add(symptom);
        symptomList.add(symptom1);
        symptomList.add(symptom2);
        disease.setSymptoms(symptomList);
        disease.setName("Common cold");
        diseaseDao.save(disease);
        Disease disease1 =  new Disease();
        disease1.setName("disease1");
        Set<Symptom> symptomList1 = new HashSet<>();
        symptomList1.add(symptom);
        symptomList1.add(symptom1);
        disease1.setSymptoms(symptomList1);
        diseaseDao.save(disease1);
        Disease disease2 =  new Disease();
        disease2.setName("disease2");
        Set<Symptom> symptomList2 = new HashSet<>();
        symptomList2.add(symptom);
        symptomList2.add(symptom1);
        disease2.setSymptoms(symptomList2);
        diseaseDao.save(disease2);
    }

    public List<Disease> getAllDiseases() {
        return diseaseDao.findAll();
    }

    public Disease getDisease(Integer id) {
        return diseaseDao.findOne(id);
    }
}
