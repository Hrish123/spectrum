package com.spectrum.service;

import com.spectrum.model.SpectrumDetails;

import java.io.PrintWriter;
import java.util.List;

public interface ExportService {

    List<SpectrumDetails> exportJson(String field, int sortType);

    void exportCSV(String field, int sortType, PrintWriter writer);
}
