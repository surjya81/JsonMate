package com.bluebird.jsonmate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluebird.jsonmate.entity.Template;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
}