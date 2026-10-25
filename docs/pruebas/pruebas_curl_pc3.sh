#!/usr/bin/env bash
# ==============================================================================
# Script de Pruebas de API con cURL — Práctica Calificada 3 (P3)
# OverText E-commerce (Spring Boot + Supabase PostgreSQL)
# Responsable: Jhade (QA & Controladores API)
# ==============================================================================

BASE_URL="http://localhost:8080/api/productos"

echo "=================================================================="
echo " INICIANDO SUITE DE PRUEBAS PARA EVALUACIÓN P3 (OVERTEXT APIS)"
echo "=================================================================="

echo ""
echo "[1/7] GET - Listar todos los productos (Select JPA)..."
curl -s -X GET "${BASE_URL}" -H "Accept: application/json" | jq . || curl -s -X GET "${BASE_URL}"

echo ""
echo "------------------------------------------------------------------"
echo "[2/7] GET - Listar productos disponibles (Select Nativo con stock > 0)..."
curl -s -X GET "${BASE_URL}/nativos" -H "Accept: application/json" | jq . || curl -s -X GET "${BASE_URL}/nativos"

echo ""
echo "------------------------------------------------------------------"
echo "[3/7] GET con Validación Positiva - Buscar por ID válido (ID: 1)..."
curl -s -X GET "${BASE_URL}/1" -H "Accept: application/json" | jq . || curl -s -X GET "${BASE_URL}/1"

echo ""
echo "------------------------------------------------------------------"
echo "[4/7] GET con Validación que debe FALLAR - Buscar por ID negativo (ID: -5)..."
echo "(Debe retornar HTTP 400 por validación @Positive en GET):"
curl -i -s -X GET "${BASE_URL}/-5" | head -n 12

echo ""
echo "------------------------------------------------------------------"
echo "[5/7] POST con Validación VÁLIDA - Crear nuevo producto..."
curl -s -X POST "${BASE_URL}" \
  -H "Content-Type: application/json" \
  -d '{
    "codigo": "PROD-TEST-99",
    "nombre": "Short Oversized Edición Especial",
    "slogan": "Exclusivo para pruebas P3",
    "descripcion": "Short fabricado para verificación del CRUD en Supabase",
    "precio": 59.90,
    "stock": 10,
    "correoProveedor": "contacto.taller@overtext.pe",
    "categoriaId": 1
  }' | jq . || curl -s -X POST "${BASE_URL}" -H "Content-Type: application/json" -d '{"codigo":"PROD-TEST-99","nombre":"Short Oversized Edicion Especial","precio":59.90,"stock":10,"correoProveedor":"contacto.taller@overtext.pe","categoriaId":1}'

echo ""
echo "------------------------------------------------------------------"
echo "[6/7] POST con Validaciones que debe FALLAR - Prueba Bean Validation..."
echo "(Probando @Size, @Positive, @Email, @NotBlank):"
curl -i -s -X POST "${BASE_URL}" \
  -H "Content-Type: application/json" \
  -d '{
    "codigo": "",
    "nombre": "A",
    "precio": -20.00,
    "stock": -1,
    "correoProveedor": "correo-invalido-sin-arroba",
    "categoriaId": 1
  }' | head -n 25

echo ""
echo "------------------------------------------------------------------"
echo "[7/7] PUT y DELETE - Actualizar y Eliminar..."
echo "PUT Actualizar precio:"
curl -s -X PUT "${BASE_URL}/1" \
  -H "Content-Type: application/json" \
  -d '{
    "codigo": "PROD-NEG-01",
    "nombre": "Short Negro Premium Actualizado",
    "precio": 49.90,
    "stock": 25,
    "correoProveedor": "proveedor.lima@overtext.pe",
    "categoriaId": 1
  }' | jq . || curl -s -X PUT "${BASE_URL}/1" -H "Content-Type: application/json" -d '{"codigo":"PROD-NEG-01","nombre":"Short Negro Premium","precio":49.90,"stock":25,"correoProveedor":"proveedor.lima@overtext.pe","categoriaId":1}'

echo ""
echo "=================================================================="
echo " SUITE DE PRUEBAS COMPLETADA"
echo "=================================================================="
