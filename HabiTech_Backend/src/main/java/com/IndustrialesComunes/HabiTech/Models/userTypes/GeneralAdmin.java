package com.IndustrialesComunes.HabiTech.Models.userTypes;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("adminGeneral")

public class GeneralAdmin extends Admin{

}