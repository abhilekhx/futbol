package com.adhikari.futbol.dtos;

public class ResourceCreationResponse {

    public ResourceCreationResponse(){super();}

    public ResourceCreationResponse(String id){
        this.id = id;
    }

    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResourceCreationResponse{" +
                "id='" + id + '\'' +
                '}';
    }
}
