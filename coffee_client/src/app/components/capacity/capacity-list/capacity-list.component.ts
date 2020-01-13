import {Component, OnInit} from '@angular/core';
import {Capacity} from '../../../models/capacity.model';
import {CapacityService} from '../../../services/capacity.service';

@Component({
  selector: 'app-capacity-list',
  templateUrl: './capacity-list.component.html',
  styleUrls: ['./capacity-list.component.css']
})
export class CapacityListComponent implements OnInit {
  listCapacity: Capacity[];

  constructor(private capacityService: CapacityService) {
  }

  ngOnInit() {
    this.capacityService.getCapacity().subscribe(next => (this.listCapacity = next), error => (this.listCapacity = []));
  }
  delete(capacity: Capacity) {
    this.capacityService.deleteCapacity(capacity).subscribe(data => {
      this.listCapacity = this.listCapacity.filter(p => p !== capacity);
    });
  }

}
