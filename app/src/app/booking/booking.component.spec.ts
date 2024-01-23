import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookingComponent } from './booking.component';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { MockService } from '../utils/mock-service.spec';

describe('BookingComponent', () => {
  let component: BookingComponent;
  let fixture: ComponentFixture<BookingComponent>;
  let userService: UserService;
  let tokenStorageService: TokenStorageService;


  beforeEach(() => {
    userService = MockService.mock('UserService', ['getPublicContent', 'getUserContent',
      'getUserByEmail', 'getNearestHospital', 'registerPatientInfo', 'getAllSpecialityGroups', 'getSpecialitiesBySpecialityGroupByName',
      'getSpecialitiesBySpecialityGroupById', 'getPerimeter']);
    tokenStorageService = MockService.mock('TokenStorageService', ['signOut', 'saveToken', 'getToken', 'saveUser', 'getUser']);
  });

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BookingComponent],
      providers: [
        { provide: UserService, useValue: userService },
        { provide: TokenStorageService, useValue: tokenStorageService }
      ],
    }).overrideComponent(BookingComponent, {
      // Setter le template à la valeur '' pour nepas gérer le code html.
      // On se concentre uniquement sur la logique métier.
      set: {
        template: ''
      }
    }).compileComponents();
    fixture = TestBed.createComponent(BookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
