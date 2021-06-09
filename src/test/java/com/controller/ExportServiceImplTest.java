package com.controller;

import com.spectrum.model.SpectrumDetails;
import com.spectrum.model.energy.*;
import com.spectrum.service.impl.ExportServiceImpl;
import com.spectrum.utilities.ExportUtility;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class ExportServiceImplTest {

    @InjectMocks
    ExportServiceImpl exportServiceImpl;

    @Test
    public void defaultTest(){
        ExportUtility exportUtility = Mockito.spy(ExportUtility.class);
        List<SpectrumDetails> spectrumDetails =exportServiceImpl.getFilteredData("releases",0, getMockData());
        System.out.println("spectrumDetails"+spectrumDetails);
    }

    private JSONObject getMockData(){
        JSONObject mockJSONObject = new JSONObject();
        JSONArray mockRelease = new JSONArray();
        mockJSONObject.put("releases",mockRelease);

        JSONObject org1 = new JSONObject();
        JSONObject createdDate = new JSONObject();
        createdDate.put("created","2017-10-25");
        org1.put("date",createdDate);
        org1.put("laborHours",12.1);
        org1.put("organization","T1");
        org1.put("status","Production");
        JSONObject permissions =  new JSONObject();
        JSONArray licenses = new JSONArray();
        JSONObject l1 =  new JSONObject();
        l1.put("name","L1");
        JSONObject l2 =  new JSONObject();
        l2.put("name","L2");
        permissions.put("licenses",licenses);
        org1.put("permissions",permissions);
        mockJSONObject.put("releases",mockRelease);
        System.out.println("mockJSONObject"+ mockJSONObject);

       return mockJSONObject;
    }

    public Root getTesData() {


        MeasurementType measurementType = MeasurementType.builder()
                .ifOther("")
                .method("other")
                .build();
        List<Release> releases = new ArrayList<>();
        License license1 = new License().builder().uRL("https://api.github.com/licenses/bsd-3-clause").name("BSD-3-Clause").build();
        ArrayList<License> licenses = new ArrayList<>();
        licenses.add(license1);

        Release release1 = Release.builder()
                .contact(new Contact().builder().email("jcrouch@sandia.gov").build())
                .date(new Date().builder().created("2017-10-25").metadataLastUpdated("2017-10-25").build())
                .description("Teuchos is designed to provide portable, object-oriented tools for Trillnos developers and users. This includes templated wrappers to BLAS/LAPACK, a serial dense matrix class, a parameter list, XML parsing utilities, reference counted pointer (smart pointer) utilities, and more. These tools are designed to run on both serial and parallel computers.")
                .laborHours(8344830.4)
                .name("Teuchos Utility Package")
                .organization("Sandia National Laboratories (SNL)")
                .permissions(new Permissions().builder().licenses(licenses).usageType("openSource").build())
                .repositoryURL("https://github.com/trilinos/Trilinos")
                .status("Production")
                .build();



        Root root = Root.builder()
                .measurementType(measurementType)
                .agency("DOE")
                .releases(Arrays.asList(release1))
                .build();

        return root;
    }
}
