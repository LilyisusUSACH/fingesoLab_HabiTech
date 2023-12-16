package com.IndustrialesComunes.HabiTech.Controllers.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageDTO{

    public Long receiverID;
    public String message;

}
