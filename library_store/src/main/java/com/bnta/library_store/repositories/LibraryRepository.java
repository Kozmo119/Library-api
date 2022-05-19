package com.bnta.library_store.repositories;

import com.bnta.library_store.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
