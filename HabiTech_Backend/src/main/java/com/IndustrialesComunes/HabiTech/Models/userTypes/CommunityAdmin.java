package com.IndustrialesComunes.HabiTech.Models.userTypes;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue("adminComunidad")

public class CommunityAdmin extends Admin{
}
