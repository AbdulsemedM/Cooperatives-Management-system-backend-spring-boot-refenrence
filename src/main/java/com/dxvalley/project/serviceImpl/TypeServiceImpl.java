package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Type;
import com.dxvalley.project.repositories.TypeRepository;
import com.dxvalley.project.services.TypeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private final TypeRepository typeRepository;

    @Override
    public Type addType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type editType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type getTypeById(Long typeId) {
        return typeRepository.findTypeByTypeId(typeId);
    }

    @Override
    public void deleteType(Long typeId) {
         typeRepository.deleteById(typeId);
    }

    @Override
    public Type getTypeByName(String typeName) {
        return typeRepository.findTypeByTypeName(typeName);
    }
    
}
