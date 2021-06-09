package com.spectrum.model.energy;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

@Data
@Builder

public class Date{
    public String created;
    public String metadataLastUpdated;
    @Tolerate
    public Date(){

    }
}
