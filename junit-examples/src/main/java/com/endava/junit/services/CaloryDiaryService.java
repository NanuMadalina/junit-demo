package com.endava.junit.services;

import com.endava.junit.model.ArchiveEntry;
import com.endava.junit.model.Operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by astoicovici on 9/26/2018.
 */
public class CaloryDiaryService {

    private List<ArchiveEntry> entries = new ArrayList<>();

    public boolean addArchiveEntry(ArchiveEntry newEntry) {
        return entries.add(newEntry);
    }

    public List<ArchiveEntry> getAllEntries() {
        // TODO implement it
        return null;
    }

    public List<ArchiveEntry> getAllFoodEntries() {
        // TODO implement it
        return null;
    }

    public List<ArchiveEntry> getAllSportsEntries() {
        // TODO implement it
        return null;
    }

    public List<ArchiveEntry> getAllEntries(final Date date, final Operation operationType) {
        // TODO implement it
        return null;
    }

}
