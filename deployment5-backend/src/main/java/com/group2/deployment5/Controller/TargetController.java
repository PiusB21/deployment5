package com.group2.deployment5.Controller;

import com.group2.deployment5.DTO.TargetDTO;
import com.group2.deployment5.ServiceImpl.TargetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/target")
public class TargetController {
    @Autowired
    private TargetServiceImpl targetService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody TargetDTO targetDTO) {
        try{
            return ResponseEntity.ok(targetService.create(targetDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllTargets() {
        return ResponseEntity.ok(targetService.getAll());
    }

    @PostMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TargetDTO targetDTO) {
        try{
            return ResponseEntity.ok(targetService.update(id,targetDTO));
        } catch (RuntimeException e) {
            return  ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            targetService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
