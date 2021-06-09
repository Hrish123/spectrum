package com.spectrum.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spectrum.model.SpectrumDetails;
import com.spectrum.model.energy.*;
import com.spectrum.service.impl.ExportServiceImpl;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class ExportServiceImplTest {

    @InjectMocks
    ExportServiceImpl exportServiceImpl;

    @Test
    public void defaultTest() throws JsonProcessingException {
        List<SpectrumDetails> spectrumDetails = exportServiceImpl.getFilteredData("test", 0, new JSONObject(new ObjectMapper().writeValueAsString(getTesData())));
        Assert.assertEquals(2, spectrumDetails.size());
    }

    @Test
    public void sortByOrganizationDescending() throws JsonProcessingException {
        List<SpectrumDetails> spectrumDetails = exportServiceImpl.getFilteredData("organization", 1, new JSONObject(new ObjectMapper().writeValueAsString(getTesData())));
        Assert.assertEquals(2, spectrumDetails.size());
        Assert.assertEquals(1, spectrumDetails.get(0).getRelease_count());
        Assert.assertEquals("B-Org", spectrumDetails.get(0).getOrganization());
    }

    @Test
    public void sortByReleaseCountDescending() throws JsonProcessingException {
        List<SpectrumDetails> spectrumDetails = exportServiceImpl.getFilteredData("release", 1, new JSONObject(new ObjectMapper().writeValueAsString(getTesData())));
        Assert.assertEquals(2, spectrumDetails.size());
        Assert.assertEquals(2, spectrumDetails.get(0).getRelease_count());
        Assert.assertEquals("A-Org", spectrumDetails.get(0).getOrganization());
    }

    public Root getTesData() {
        MeasurementType measurementType = MeasurementType.builder()
                .ifOther("")
                .method("other")
                .build();
        License license1 = new License().builder().uRL("https://api.github.com/licenses/bsd-3-clause").name("L1").build();
        License license2 = new License().builder().uRL("https://api.github.com/licenses/bsd-3-clause").name("L2").build();

        Release release1 = Release.builder()
                .contact(new Contact().builder().email("jcrouch@sandia.gov").build())
                .date(new Date().builder().created("2017-10-25").metadataLastUpdated("2017-10-25").build())
                .description("Teuchos is designed to provide portable, object-oriented tools for Trillnos developers and users. This includes templated wrappers to BLAS/LAPACK, a serial dense matrix class, a parameter list, XML parsing utilities, reference counted pointer (smart pointer) utilities, and more. These tools are designed to run on both serial and parallel computers.")
                .laborHours(8344830.4)
                .name("Teuchos Utility Package")
                .organization("A-Org")
                .permissions(new Permissions().builder().licenses(Arrays.asList(license1)).usageType("openSource").build())
                .repositoryURL("https://github.com/trilinos/Trilinos")
                .status("Production")
                .build();

        Release release2 = Release.builder()
                .contact(new Contact().builder().email("jcrouch@sandia.gov").build())
                .date(new Date().builder().created("2017-10-25").metadataLastUpdated("2017-10-25").build())
                .description("Teuchos is designed to provide portable, object-oriented tools for Trillnos developers and users. This includes templated wrappers to BLAS/LAPACK, a serial dense matrix class, a parameter list, XML parsing utilities, reference counted pointer (smart pointer) utilities, and more. These tools are designed to run on both serial and parallel computers.")
                .laborHours(8344830.4)
                .name("Teuchos Utility Package")
                .organization("B-Org")
                .permissions(new Permissions().builder().licenses(Arrays.asList(license1, license2)).usageType("openSource").build())
                .repositoryURL("https://github.com/trilinos/Trilinos")
                .status("Production")
                .build();

        Release release3 = Release.builder()
                .contact(new Contact().builder().email("jcrouch@sandia.gov").build())
                .date(new Date().builder().created("2017-10-25").metadataLastUpdated("2017-10-25").build())
                .description("Teuchos is designed to provide portable, object-oriented tools for Trillnos developers and users. This includes templated wrappers to BLAS/LAPACK, a serial dense matrix class, a parameter list, XML parsing utilities, reference counted pointer (smart pointer) utilities, and more. These tools are designed to run on both serial and parallel computers.")
                .laborHours(8344830.4)
                .name("Teuchos Utility Package")
                .organization("A-Org")
                .permissions(new Permissions().builder().licenses(Arrays.asList(license2)).usageType("openSource").build())
                .repositoryURL("https://github.com/trilinos/Trilinos")
                .status("Production")
                .build();

        Root root = Root.builder()
                .measurementType(measurementType)
                .agency("DOE")
                .releases(Arrays.asList(release1, release2, release3))
                .build();

        return root;
    }
}
