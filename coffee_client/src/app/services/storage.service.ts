import {Injectable} from '@angular/core';

@Injectable()
export class StorageService {
  public get(): Storage {
    return localStorage;
  }
}
