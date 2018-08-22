import { Show } from "./Show";
export class MovieEvent {
    movieEventId: number;
    movieId:number;
    theatreId: number;
    theatreName:string;
    showCount: number;
    bookingStartDate: Date;
    bookingEndDate: Date;
    weeks:number;
    shows:Show[];
    city:string;
    userName:string;
    timings:string;
  }