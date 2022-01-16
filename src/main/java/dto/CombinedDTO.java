/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author mathi
 */
public class CombinedDTO {
   private HarbourDTO chuck_Joke;
   private  BoatDTO random_Joke;
   private StarWarsShipDTO starWarsShip_INFO;
   private CatFactDTO catFact;

    public CombinedDTO(HarbourDTO chuck_Joke, BoatDTO random_Joke, StarWarsShipDTO starWarsShip_INFO, CatFactDTO catFact) {
        this.chuck_Joke = chuck_Joke;
        this.random_Joke = random_Joke;
        this.starWarsShip_INFO = starWarsShip_INFO;
        this.catFact = catFact;
    }

    public HarbourDTO getChuck_Joke() {
        return chuck_Joke;
    }

    public void setChuck_Joke(HarbourDTO chuck_Joke) {
        this.chuck_Joke = chuck_Joke;
    }

    public BoatDTO getRandom_Joke() {
        return random_Joke;
    }

    public void setRandom_Joke(BoatDTO random_Joke) {
        this.random_Joke = random_Joke;
    }

    public StarWarsShipDTO getStarWarsShip_INFO() {
        return starWarsShip_INFO;
    }

    public void setStarWarsShip_INFO(StarWarsShipDTO starWarsShip_INFO) {
        this.starWarsShip_INFO = starWarsShip_INFO;
    }

    public CatFactDTO getCatFact() {
        return catFact;
    }

    public void setCatFact(CatFactDTO catFact) {
        this.catFact = catFact;
    }

   

    public HarbourDTO getCDTO() {
        return chuck_Joke;
    }

    public void setCDTO(HarbourDTO CDTO) {
        this.chuck_Joke = CDTO;
    }

    public BoatDTO getJDTO() {
        return random_Joke;
    }

    public void setJDTO(BoatDTO JDTO) {
        this.random_Joke = JDTO;
    }

    public StarWarsShipDTO getSWSDTO() {
        return starWarsShip_INFO;
    }

    public void setSWSDTO(StarWarsShipDTO SWSDTO) {
        this.starWarsShip_INFO = SWSDTO;
    }


    @Override
    public String toString() {
        return "CombinedDTO{" + "CDTO=" + chuck_Joke + ", JDTO=" + random_Joke + ", SWSDTO=" + starWarsShip_INFO + '}';
    }
   
   
   
   
}
