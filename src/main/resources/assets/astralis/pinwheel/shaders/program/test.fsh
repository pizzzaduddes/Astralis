#version 150

in vec2 texCoord;
in vec3 worldPos;

out vec4 fragColor;

// Simple hash function for noise
float rand(vec2 co) {
    return fract(sin(dot(co.xy ,vec2(12.9898,78.233))) * 43758.5453);
}

void main() {
    float noise = rand(worldPos.xy * 10.0); // tweak scale for detail
    vec3 color = vec3(noise); // grayscale noise
    fragColor = vec4(color, 1.0);
}
