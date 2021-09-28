package com.usb.arquitectura.service;

import com.usb.arquitectura.domain.*;
import com.usb.arquitectura.exception.*;
import com.usb.arquitectura.repository.*;
import com.usb.arquitectura.utility.Utilities;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
@Slf4j
public class ClipsServiceImpl implements ClipsService {
    @Autowired
    private ClipsRepository clipsRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(Clips clips) throws ConstraintViolationException {
        Set<ConstraintViolation<Clips>> constraintViolations = validator.validate(clips);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return clipsRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clips> findAll() {
        log.debug("finding all Clips instances");

        return clipsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Clips save(Clips entity) throws Exception {
        log.debug("saving Clips instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Clips");
        }

        validate(entity);

        if (clipsRepository.existsById(entity.getIdclip())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return clipsRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Clips entity) throws Exception {
        log.debug("deleting Clips instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Clips");
        }

        if (entity.getIdclip() == null) {
            throw new ZMessManager().new EmptyFieldException("idclip");
        }

        if (clipsRepository.existsById(entity.getIdclip()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        clipsRepository.deleteById(entity.getIdclip());
        log.debug("delete Clips successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        log.debug("deleting Clips instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("idclip");
        }

        if (clipsRepository.existsById(id)) {
            delete(clipsRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Clips update(Clips entity) throws Exception {
        log.debug("updating Clips instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Clips");
        }

        validate(entity);

        if (clipsRepository.existsById(entity.getIdclip()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return clipsRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Clips> findById(Integer idclip) {
        log.debug("getting Clips instance");

        return clipsRepository.findById(idclip);
    }
}
