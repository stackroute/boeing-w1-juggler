import { Component, OnInit } from "@angular/core";
import { FormControl } from "@angular/forms";

@Component({
  selector: "app-movie-creation",
  templateUrl: "./movie-creation.component.html",
  styleUrls: ["./movie-creation.component.css"]
})
export class MovieCreationComponent implements OnInit {
  pokemonControl = new FormControl();
  pokemonGroups: PokemonGroup[] = [
    {
      name: "PVR",
      pokemon: [
        { value: "PVR INOX", viewValue: "PVR INOX" },
        { value: "PVR GOLDCLASS", viewValue: "PVR GOLDCLASS" },
        { value: "PVR FAMILY", viewValue: "PVR FAMILY" }
      ]
    },
    {
      name: "Water",
      pokemon: [
        { value: "squirtle-3", viewValue: "Squirtle" },
        { value: "psyduck-4", viewValue: "Psyduck" },
        { value: "horsea-5", viewValue: "Horsea" }
      ]
    },
    {
      name: "Fire",
      disabled: true,
      pokemon: [
        { value: "charmander-6", viewValue: "Charmander" },
        { value: "vulpix-7", viewValue: "Vulpix" },
        { value: "flareon-8", viewValue: "Flareon" }
      ]
    },
    {
      name: "Psychic",
      pokemon: [
        { value: "mew-9", viewValue: "Mew" },
        { value: "mewtwo-10", viewValue: "Mewtwo" }
      ]
    }
  ];

  constructor() {}

  ngOnInit() {}
}

export interface Pokemon {
  value: string;
  viewValue: string;
}

export interface PokemonGroup {
  disabled?: boolean;
  name: string;
  pokemon: Pokemon[];
}
