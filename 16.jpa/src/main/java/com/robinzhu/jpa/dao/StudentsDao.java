package com.robinzhu.jpa.dao;

import com.robinzhu.jpa.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Create by zhudapeng
 * 2019-08-27 20:54
 */
public interface StudentsDao extends PagingAndSortingRepository<Student, String> {
}
