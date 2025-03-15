package com.astralismod.astralis.entity.planet.solar_system;

import com.astralismod.astralis.Astralis;
import com.astralismod.astralis.entity.renderer.planet.Planet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class EarthEntity extends Entity implements Planet {
    public EarthEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {}

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {}

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {}

    @Override
    public Identifier planetTexture() {
        return Astralis.resLoc("textures/planet/solar_system/earth.png");
    }

    @Override
    public float planetSize() {
        return 200.0f;
    }

    @Override
    public float axialTilt() {
        return 20.0f;
    }

    @Override
    public float rotationSpeed() {
        return 1.0f;
    }
}
