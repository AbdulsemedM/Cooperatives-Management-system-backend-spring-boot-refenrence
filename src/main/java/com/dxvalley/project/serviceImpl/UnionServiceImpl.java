package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.UnionRepository;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UnionServiceImpl implements UnionService {
   @Autowired	
   private final UnionRepository unionRepository;
    @Override
    public Unions addUnion(Unions union) {
       return unionRepository.save(union);
    }

    @Override
    public Unions editUnion(Unions union) {
        return unionRepository.save(union);
    }

    @Override
    public List<Unions> getUnion() {
       return unionRepository.findAll();
    }

    @Override
    public Unions getUnionById(Long unionId) {
       return unionRepository.findUnionsByUnionId(unionId);
    }

    @Override
    public void deleteUnion(Long uniodId) {
       unionRepository.deleteById(uniodId);
    }

    @Override
    public Unions getUnionByName(String name) {
        return unionRepository.findUnionsByName(name);
    }
    
}
