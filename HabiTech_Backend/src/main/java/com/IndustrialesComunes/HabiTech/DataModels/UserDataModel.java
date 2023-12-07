package com.IndustrialesComunes.HabiTech.DataModels;

import com.IndustrialesComunes.HabiTech.Models.User;
import com.IndustrialesComunes.HabiTech.Models.userTypes.Residente;

import java.util.List;

public interface UserDataModel {
    // Aca se debe definir como se conecta el usuario a la base de datos de manera general
        List<User> getUsuarios();

        void eliminar(Long id);

        void registrar(User user);

}
