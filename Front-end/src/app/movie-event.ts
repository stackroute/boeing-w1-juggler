import { Show } from "./Show";
export class MovieEvent {
    movieId: number;
    theatreId: number;
    showCount: number;
    bookingStartDate: Date;
    bookingEndDate: Date;
    shows: Show[];
    city: string;
  }
 